echo SELECT 'CREATE DATABASE librarymanagementsystem_product_testingcode' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'librarymanagementsystem_product_testingcode') \gexec | psql "postgresql://:@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://:@localhost/librarymanagementsystem_product_testingcode"

java -cp librarymanagementsystem.product.testingcode --module-path librarymanagementsystem.product.testingcode -m librarymanagementsystem.product.testingcode