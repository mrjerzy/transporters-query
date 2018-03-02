FROM java:8 
WORKDIR /app
COPY TransportersQuery/target/TransportersQuery*.jar /app/
COPY TransportersQuery/config_jerzy.yml /app/
EXPOSE 8080:8080 
EXPOSE 8081:8081
CMD java -jar TransportersQuery*.jar server ./config_jerzy.yml

