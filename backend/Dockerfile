# استفاده از یک نسخه مناسب جاوا
FROM openjdk:19-jdk

# تنظیم دایرکتوری کاری داخل کانتینر
WORKDIR /app

# کپی کردن فایل JAR ساخته شده به داخل کانتینر
COPY target/friendalyze-1.0.0.jar app.jar

# پورت مورد استفاده
EXPOSE 8080

# اجرای اپلیکیشن
CMD ["java", "-jar", "app.jar"]
