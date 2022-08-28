package com.pro.springapp;
import com.pro.springapp.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.Property;

//completed - 2. удалить лишние ресурсы из проекта и гита => ticker.json
//    -1. для каждого из последующих изменений создавать новую ветку и после окончания разработки мержить результаты этой ветки в ветку main/master
//completed  - 0.a создать ветку 'refactoring': странные места, которые показывает идея (избавиться от require non null, поправить везде,
//      где подсвечивает идея и так далее).
//    0.b привести в порядок структуру проекта
//    1. создать ветку 'cache': подумать над реализацией кеша через любой доступный ORM и базу данных (и от Тани: обязательно через транзакции)


// как влить изменения из другой ветки:
// 1. переходишь в ветку, в которую хочешь влить другую ветку
// 2. git merge ветка_с_новыми_изменениями

@SpringBootApplication
@Import(SpringConfig.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
    }
}