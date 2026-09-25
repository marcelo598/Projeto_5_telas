# Projeto 5 Telas - Java Web

Projeto acadêmico com:
- 5 páginas JSP estilizadas
- Navegação funcional entre páginas
- API REST
- PostgreSQL
- Servlets
- DAO
- Java 17
- Tomcat 10.1

## Telas
1. Login
2. Cadastro
3. Home
4. Produtos
5. Detalhes do produto

## Banco
Execute `database.sql` no PostgreSQL.

Por padrão o projeto usa:
- host: localhost
- porta: 5432
- banco: projeto5telas
- usuário: postgres
- senha: postgres

Se sua senha for diferente, altere `src/main/java/br/com/projeto/config/Database.java`.

## API
GET /Projeto5Telas/api/produtos
GET /Projeto5Telas/api/produtos?id=1
POST /Projeto5Telas/api/usuarios

## Execução
1. Abra no IntelliJ como projeto Maven.
2. Configure JDK 17.
3. Configure Tomcat 10.1.
4. Crie o banco usando database.sql.
5. Rode o projeto.
6. Abra:
http://localhost:8080/Projeto5Telas/
