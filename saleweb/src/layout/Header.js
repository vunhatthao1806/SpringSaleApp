import { useContext, useEffect, useState } from "react";
import APIs, { endpoints } from "../configs/APIs";
import "bootstrap/dist/css/bootstrap.min.css";
import {
  Badge,
  Button,
  Container,
  Form,
  Image,
  Nav,
  Navbar,
  NavDropdown,
} from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { MyCartContext, MyDispatchContext, MyUserContext } from "../App";
const Header = () => {
  const user = useContext(MyUserContext);
  const dispatch = useContext(MyDispatchContext);
  const [cartCounter] = useContext(MyCartContext);
  const [categories, setCategories] = useState([]);
  const [q, setQ] = useState("");
  const nav = useNavigate();
  const loadCates = async () => {
    let res = await APIs.get(endpoints["categories"]);
    setCategories(res.data);
  };
  useEffect(() => {
    loadCates();
  }, []);
  const search = (e) => {
    e.preventDefault();
    nav(`/?kw=${q}`);
  };
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="#home">E-commerce Website</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Link to="/" className="nav-link">
                Trang chủ
              </Link>

              <NavDropdown title="Danh mục" id="basic-nav-dropdown">
                {categories.map((c) => {
                  const url = `/?cateId=${c.id}`;
                  return (
                    <Link keys={c.id} to={url} className="dropdown-item">
                      {c.name}
                    </Link>
                  );
                })}
              </NavDropdown>
              {user === null ? (
                <>
                  <Link to="/login" className="nav-link text-danger">
                    Đăng nhập
                  </Link>
                  <Link to="/register" className="nav-link text-primary">
                    Đăng ký
                  </Link>
                </>
              ) : (
                <>
                  <Link to="/" className="nav-link text-danger">
                    <Image src={user.avatar} roundedCircle width={40} />
                    Chào {user.username}!
                  </Link>
                  <Button
                    className="btn btn-danger"
                    onClick={() => dispatch({ type: "logout" })}
                  >
                    Đăng xuất
                  </Button>
                </>
              )}
              <Link to="/cart" className="nav-link text-danger">
                &#128722; <Badge className="bg-danger">{cartCounter}</Badge>
              </Link>
            </Nav>
            <Form className="d-flex" onSubmit={search}>
              <Form.Control
                type="search"
                placeholder="Tìm sản phẩm"
                className="me-2"
                aria-label="Search"
                value={q}
                onChange={(e) => setQ(e.target.value)}
              />
              <Button variant="outline-success" type="submit">
                Tìm
              </Button>
            </Form>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
};
export default Header;
