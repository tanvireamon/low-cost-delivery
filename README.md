# Low Cost Delivery System (Spring Boot)

A multi-module delivery management system built with **Spring Boot 3 / Java 21**, **Thymeleaf**, **Spring Data JPA**, and **MySQL**.  
It supports multiple delivery types (Instant, Local Area, Inter/Outer City), order listing for earn-people (riders), and session-based authentication.

---

## Features

### Delivery Modules
- ✅ **Instant Delivery**
- ✅ **Local Area Delivery**
- ✅ **Inter / Outer City Delivery**
- ✅ Form submission + validation-ready Thymeleaf pages
- ✅ Success message using **HttpSession** (one-time message)

### Earn People (Rider) Module
- ✅ **Available Orders** page (DB থেকে orders দেখায়)
- ✅ Accept / Reject buttons (endpoints ready; status update can be added)

### Authentication
- ✅ Registration + Login (custom controller)
- ✅ **Session-based Spring Security Authentication**
- Stores logged-in user in session: `session.setAttribute("loggedUser", user);`
- Custom filter reads session user and sets SecurityContext

### Database
- ✅ MySQL + JPA Entities & Repositories
- ✅ `order_id` mapping for InstantDelivery primary key and FK linking from other modules (when configured)

---

## Tech Stack

- Java 21
- Spring Boot 3.x
- Spring MVC
- Thymeleaf
- Spring Data JPA (Hibernate)
- MySQL
- Lombok
- Spring Security (session-based, not JWT)
- Bootstrap 5

---

## Project Structure (Typical)

```text
src/main/java/com/LowCost/Delivery
 ├── controller/
 ├── service/
 ├── service/impl/
 ├── repository/
 ├── model/
 ├── config/   (SessionAuthFilter, SecurityConfig, etc.)
src/main/resources/
 ├── templates/
 ├── static/
     ├── images/
     ├── css/
     └── js/
