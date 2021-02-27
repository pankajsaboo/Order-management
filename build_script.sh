echo "Building using "$1"-Profile"
mvn clean compile -DskipTests
mvn clean package -DskipTests
cd target
java -jar -Dspring.profiles.active=$1 order-management-1.0.0.jar -DskipTests
cd ..
$SHELL
