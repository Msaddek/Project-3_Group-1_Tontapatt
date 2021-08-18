# Tontapatt 
![version](https://img.shields.io/badge/Maintained%3F-yes-green.svg) [![GitHub contributors](https://img.shields.io/github/contributors/hajjoujti/Project-3_Group-1_Tontapatt.svg)](https://GitHub.com/hajjoujti/Project-3_Group-1_Tontapatt/graphs/contributors/) [![Open Source? Yes!](https://badgen.net/badge/Open%20Source%20%3F/Yes%21/blue?icon=github)](https://github.com/hajjoujti/Project-3_Group-1_Tontapatt/)
<br/>
![version](http://ForTheBadge.com/images/badges/built-by-developers.svg) ![version](http://ForTheBadge.com/images/badges/built-with-love.svg)
[![ForTheBadge makes-people-smile](http://ForTheBadge.com/images/badges/makes-people-smile.svg)](http://ForTheBadge.com) [![ForTheBadge winter-is-coming](http://ForTheBadge.com/images/badges/winter-is-coming.svg)](http://ForTheBadge.com)

---

## Langages
![css version](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![css version](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![css version](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![css version](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)
![css version](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![css version](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)

---

## Logiciels
![css version](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
![Firefox](https://img.shields.io/badge/Firefox-FF7139?style=for-the-badge&logo=Firefox-Browser&logoColor=white)
![Google Chrome](https://img.shields.io/badge/Google%20Chrome-4285F4?style=for-the-badge&logo=GoogleChrome&logoColor=white)
![css version](https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white)
![Microsoft Office](https://img.shields.io/badge/Microsoft_Office-D83B01?style=for-the-badge&logo=microsoft-office&logoColor=white)
![css version](https://aleen42.github.io/badges/src/photoshop.svg)<br/>



---
## Installation
![css version](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
- Creez une base de données `tontapatt_db`
- Télécharger mysql-connector-java-8.0.26

![css version](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
- Clonez le dépot directement dans Votre IDE java
- Installez Jboss 7.2 sur votre machine
- Copiez mysql-connector-java-8.0.26 dans modules\system\layers\base\com\mysql\main du dossier Jboss
- Toujours dans le même repertoire créez un fichiez module.xml et metter le bout du code suivant:<br/>
```
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.1" name="com.mysql">
<resources>
    <resource-root path="mysql-connector-java-8.0.26.jar"/>
  </resources>
    <dependencies>
        <module  name="javax.api" />
        <module  name="javax.transaction.api" />
    </dependencies>
</module>
```
- Ajoutez maintenant le bout de code suivant comme datasources dans le fichier standalone.xml qui se trouve dans standalone\configuration du dossier Jboss:<br/>
```
<datasources>
	<datasource jta="true" jndi-name="java:jboss/datasources/tontapatt_db" pool-name="tontapatt_db" enabled="true" use-java-context="true">
		<connection-url>jdbc:mysql://localhost:3306/tontapatt_db?serverTimezone=UTC&amp;verifyServerCertificate=false&amp;useSSL=true</connection-url>
		<driver>mysql</driver>
		<security>
			<user-name>root</user-name>
			<password>root</password>
		</security>
	</datasource>
	<drivers>
		<driver name="h2" module="com.h2database.h2">
			<xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
		</driver>
		<driver name="mysql" module="com.mysql">
			<xa-datasource-class>com.mysql.cj.jdbc.MysqlXADataSource</xa-datasource-class>
		</driver>
	</drivers>
</datasources>
```
- Mettez à jour le projet Maven
- Demarrez l'appliocation via Jbss dans votre IDE

---

## Suivi du projet
Suivez les differentes phases du projet sur notre Trello

[<img alt="Trello" src="https://img.shields.io/badge/Trello-%23026AA7.svg?style=for-the-badge&logo=Trello&logoColor=white" />](https://trello.com/b/mVxEIsIk/projet-3-nico-fred-jess-basem)

---

### Participants au projet

<p align="center"><img src="https://github-readme-stats.vercel.app/api?username=hajjoujti&theme=blue-white"/></p>
<p align="center"><img src="https://github-readme-stats.vercel.app/api?username=Msaddek&theme=blue-white"</p>
<p align="center"><img src="https://github-readme-stats.vercel.app/api?username=cjessica34&theme=blue-white"</p>
<p align="center"><img src="https://github-readme-stats.vercel.app/api?username=fguyont&theme=blue-white"</p>
<p align="center"><img src="https://github-readme-stats.vercel.app/api?username=soufyaned&theme=blue-white"</p>
<p align="center"><img src="https://contributor-overtime-api.apiseven.com/contributors-svg?chart=contributorOverTime&repo=hajjoujti/Project-3_Group-1_Tontapatt"</p>
