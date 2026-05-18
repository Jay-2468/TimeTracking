⏱️ Time Tracking System

A full-stack enterprise web application developed to streamline employee productivity tracking, payroll processing, and invoice management.
Built using Java Spring MVC architecture, this system simulates real-world organizational workflows and business logic.

---

🚀 Key Highlights (For Recruiters)
* Designed and developed a multi-role system (Admin, Project Manager, Employee)
* Implemented end-to-end workflow: Task Assignment → Time Tracking → Payroll → Invoice Generation
* Built using Spring MVC + Hibernate (ORM) following layered architecture
* Integrated Email Notification System for OTP verification and system alerts
* Applied real-world business logic for salary, bonuses, and reporting
* Developed during internship with focus on scalable and maintainable code

---

🧠 Features

👤 Role-Based Access Control
* Secure login & authentication
* Authorization for Admin, PM, and Employees
  
📁 Project & Task Management
* Create projects, modules, and tasks
* Assign tasks and monitor progress

⏳ Time Tracking & Timesheets
* Log working hours
* Weekly timesheet submission
* Approval workflow (PM/Admin)

💰 Payroll System
* Monthly salary calculation
* Performance-based bonuses
* Payroll management system

🧾 Invoice System
* Generate invoices for projects
* Track billing and payments

📧 Email Notifications (Implemented ✅)
* OTP verification
* System alerts (task updates, approvals, etc.)

📊 Reports & Analytics
* Productivity reports
* Project-based performance insights

---

🛠️ Tech Stack

Backend:
* Java
* Spring MVC
* Hibernate (ORM)

Frontend:
* JSP, HTML, CSS, Bootstrap

Database:
* MySQL

Tools:
* Maven
* Apache Tomcat

---

⚙️ Installation & Setup

### Prerequisites

* Java JDK 8+
* Maven
* MySQL
* Apache Tomcat Server

### Steps

1. **Clone the repository**

```bash
git clone https://github.com/your-username/time-tracking-system.git
cd time-tracking-system
```

2. **Configure Database**

* Create a MySQL database
* Update `application.properties` or config file:

```properties
db.url=jdbc:mysql://localhost:3306/your_db
db.username=root
db.password=your_password
```

3. **Build the project**

```bash
mvn clean install
```

4. **Deploy on Tomcat**

* Deploy `.war` file in Tomcat server

5. **Run the application**

* Open browser:

```
http://localhost:8080/time-tracking-system
```

---

🔐 Roles & Responsibilities

| Role            | Responsibilities                                   |
| --------------- | -------------------------------------------------- |
| Admin           | Manage users, projects, payroll, invoices          |
| Project Manager | Assign tasks, approve timesheets, monitor progress |
| Employee        | Log time, submit timesheets                        |

---

📸 Screenshots

---

📈 Future Enhancements

* REST API integration with React frontend
* Real-time tracking
* Advanced analytics dashboard

---

👨‍💻 Author

Jay Falak

---
