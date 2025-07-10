# 🔌 JDBC (Java Database Connectivity) Projesi

Java uygulamalarının ilişkisel veritabanları ile nasıl iletişim kurduğunu anlamak için oluşturulan bir projedir.  
JDBC sayesinde veritabanına bağlanma, veri çekme, ekleme gibi işlemler Java ile doğrudan gerçekleştirilebilir.

## 🛠️ Kullanılan Teknolojiler

- Java 21  
- PostgreSQL  
- JDBC (Java Database Connectivity)  
- IntelliJ IDEA

---

## ❓ JDBC Nedir?

**JDBC (Java Database Connectivity)**, Java uygulamaları ile veritabanları arasında bağlantı kurmayı sağlayan bir API'dir.  
Yani Java koduyla örneğin bir PostgreSQL, MySQL veya Oracle veritabanına erişmeni, veri çekmeni, eklemeni sağlar.

Java'nın veritabanı ile konuşma dilidir diyebiliriz.

---

## ✅ JDBC’nin Avantajları

- **Bağımsızlık:** Java dilinden hangi veritabanına bağlanırsan bağlan, JDBC yapısıyla çalışırsın. PostgreSQL, MySQL, Oracle vb. fark etmez.
- **Esneklik:** İstediğin SQL sorgusunu oluşturabilirsin.
- **Hızlı ve Direkt Erişim:** Veritabanına doğrudan erişim sağlar, arada katman olmadığından hızlıdır.
- **PreparedStatement desteği:** SQL enjeksiyon riskine karşı daha güvenlidir.
- **Transaction kontrolü:** `commit()` ve `rollback()` gibi işlemlerle veri bütünlüğünü koruyabilirsin.
- **Ekstra kurulum gerektirmez:** JDBC Java'nın içinde gelir, sadece driver eklemek yeterlidir.

---

## 🌍 Nerelerde Kullanılır?

- Basit veritabanı projelerinde (örnek: kullanıcı kayıt sistemleri)
- Kurumsal projelerde (ERP sistemleri, banka yazılımları)
- Java Web projelerinde (Spring Boot gibi)
- Masaüstü Java uygulamalarında (JavaFX, Swing vs.)

---

## 🧩 Sınıflar Hakkında

## DatabaseConfig.java  
Veritabanı bilgilerini (URL, kullanıcı adı, şifre) sabit tutar.

## DatabaseConnector.java 
Veritabanı bağlantısını sağlar. `getConnection()` metodu ile çağrıldığında bağlantıyı açar ve `SQLException` hatalarını yönetir.

## Main.java 
Projenin giriş noktasıdır. `try-with-resources` kullanılarak bağlantı güvenli bir şekilde açılır ve tablo oluşturulur.

---

## 🚀 Projeyi Çalıştırma Adımları

1. PostgreSQL veritabanınızda `jdbc_odev1` adında bir veritabanı oluşturun.
2. `DatabaseConfig.java` içindeki kullanıcı adı, şifre, URL gibi bilgileri kendi veritabanınıza göre güncelleyin.
3. Projeyi bir Java IDE'sinde açın.
4. `Main.java` dosyasını çalıştırın.

---

## 🧪 Konsol Çıktısı (Beklenen)
Aşağıdaki çıktılar JDBC işlemlerinin başarıyla tamamlandığını gösterir.

```bash
Connected established successfully  
Table created successfully
