# Finance Service (osm-fin)

Microservice handling financial transactions, bank accounts, and expense tracking.

## 📖 Functional Overview
The financial record-keeper of the project. It tracks every cent from supplier payments to internal operating costs.

### Key Features
- **Transaction Tracking**: Detailed logs of all incoming and outgoing payments.
- **Bank Account Management**: Maintains balances and history for the company's various financial accounts.
- **Expense Management**: Tracks operating costs, salaries, and maintenance expenses.
- **Financial Reporting**: Provides data for P&L (Profit and Loss) analysis and financial health dashboards.


## 🛠 Tech Stack
- **Java 21**
- **Spring Boot 3.4.4**
- **PostgreSQL** (`osmfinance`)
- **Discovery:** Netflix Eureka

## 🚀 Getting Started
```bash
./mvnw spring-boot:run
```

## ⚙️ Configuration
| Variable | Default | Description |
| :--- | :--- | :--- |
| `SERVER_PORT` | `8085` | Service Port |
| `DB_URL` | `jdbc:postgresql://localhost:5432/osmfinance` | Database URL |
