# Proje Adı - Öğrenci ve Kurs Yönetimi

Bu proje, öğrenci ve kurs yönetimini içeren bir web uygulamasıdır. Projede MySQL, Java Spring ve Vue.js TypeScript kullanılmıştır.

## Backend (Java Spring)

Backend kısmı Spring Boot ile geliştirilmiştir. Veritabanı bağlantısı ve diğer gerekli yapılandırmalar `application.properties` dosyasında yapılmıştır.

### Veritabanı Yapılandırması

Projeyi çalıştırmadan önce, yerelde MySQL veritabanına ihtiyaç duyulmaktadır. Aşağıdaki ayarlarla bir veritabanı oluşturulmalıdır:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student-course-db?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create
server.port = 8080
```
application.properties dosyasındaki bu ayarları, MySQL'e bağlanmak için kullanılan bilgilerle değiştirmelisiniz.
### Projenin Başlatılması
Java IDE (IntelliJ IDEA, Eclipse vb.) kullanarak projeyi açın.
src klasöründeki main paketindeki Application.java dosyasını çalıştırarak Spring Boot uygulamasını başlatın.
## Frontend (Vue.js)
Frontend kısmı Vue.js ile geliştirilmiştir. Projenin çalıştırılması için aşağıdaki adımları takip edebilirsiniz:

### Proje Kurulumu
Projenin root dizinindeyken aşağıdaki komutu çalıştırarak gerekli bağımlılıkları yükleyin:
```npm install```
### Geliştirme Aşamasında Çalıştırma
Aşağıdaki komutla projeyi geliştirme modunda çalıştırabilirsiniz:
```npm run serve```
Bu komut, bir development sunucususu başlatır ve genellikle http://localhost:8080/ gibi bir adres üzerinden Vue.js uygulamanızı görebilirsiniz.
