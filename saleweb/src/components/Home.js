import { useContext, useEffect, useState } from "react";
import { Button, Card, Col, Row, Spinner } from "react-bootstrap";
import APIs, { endpoints } from "../configs/APIs";
import { Link, useSearchParams } from "react-router-dom";
import cookie from "react-cookies";
import { MyCartContext } from "../App";

const Home = () => {
  const [products, setProducts] = useState(null);
  const [q] = useSearchParams();
  const [, dispatch] = useContext(MyCartContext);
  const loadProducts = async () => {
    let url = endpoints["products"];
    let cateId = q.get("cateId");
    if (cateId !== null) url = `${url}?cateId=${cateId}`;
    let k = q.get("kw");
    if (k != null) url = `${url}?q=${k}`;
    let res = await APIs.get(url);
    setProducts(res.data);
  };
  useEffect(() => {
    loadProducts();
  }, [q]);

  const addToCart = (p) => {
    let cart = cookie.load("cart") || null;
    if (cart === null) cart = {};
    if (p.id in cart) {
      cart[p.id]["quantity"]++;
    } else {
      cart[p.id] = {
        id: p.id,
        name: p.name,
        unitPrice: p.price,
        quantity: 1,
      };
    }
    cookie.save("cart", cart);
    dispatch({
      type: "update",
    });
  };
  if (products === null) return <Spinner animation="grow" variant="primary" />;
  return (
    <>
      <h1>DANH MỤC SẢN PHẨM</h1>
      <Row>
        {products.map((p) => (
          <Col key={p.id} md={3} xs={12} className="p-1">
            <Card>
              <Card.Img variant="top" src={p.image} />
              <Card.Body>
                <Card.Title>{p.name}</Card.Title>
                <Card.Text>{p.price} VNĐ</Card.Text>
                <Button
                  variant="danger"
                  className="m-1"
                  onClick={() => addToCart(p)}
                >
                  Đặt hàng
                </Button>
                <Link className="btn btn-info" to="/">
                  Xem chi tiết
                </Link>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </>
  );
};
export default Home;
