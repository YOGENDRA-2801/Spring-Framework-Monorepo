package in.yoy.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan (basePackages = {"in.yoy.beans"})
@PropertySource("classpath:in/yoy/resources/employee.properties")
public class JavaConfigForAnno {

}

// 1. Configuration Class ka kya use ho raha hai ?
// @Configuration class ka kaam hota hai Spring container ko batana ki yeh class beans aur settings define karti hai.
// Config class khud beans define kar sakti hai, ya phir beans ko scan karwa sakti hai. Aur woh external settings (e.g., property files) ko bhi import karne ka kaam karti hai.

// 2. Property file se value Config file me kyu nahi le rahe?
// Config file ka role system setup aur scanning ka hai, data store karne ka nahi.
// Config class ek controller hai jo batata hai: kaha-kaha beans hai + kaunsi files load karni hain

// Final Verdict
// 1. practical cases me data-oriented values ko beans me hi rakhna chahiye, not config classes.

// Extra
// actual data (like my.name) kis class me chahiye? → Bean class me — kyunki bean class hi real object hai jisme hume values inject karni hain
// Agar aap AppConfig class ko context.getBean(AppConfig.class) se leke use nahi karoge to @Value ki values inject nahi hongi.