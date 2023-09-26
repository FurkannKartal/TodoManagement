# TodoManagement

### Annotations

#### @Entity :

- Bu anotasyon kullanılan classın entity olduğunu belirtir.
- Bu anotasyon veritabanında bir tablo oluşturmak için kullanılır.

```Java
@Entity
public class Todo{
---------KOD PARCACIGI---------
}
```
---
#### @Table :
- Bu anotation veri tabanında oluşturulacak olan tablonun detaylarını vermek için kullanılır
- Ayrıca bu anotation tablonun ismini vermek için kullanılır

```Java
@Entity
@Table(name = "todos")
public class Brand {

---------KOD PARCACIGI---------
}
```

#### @Column :
- Bu anotation databasede oluşturulacak olan columnlar için bilgiler vermye yarar.
- Bu column için de isim verilir.

```Java


@Entity
@Table(name = "todos")
public class Todo {

    @Column(name = "id")
    private int id;
}
```

---

#### @Id :

- @Id anotasyonu, bir sınıfın alanının primary key olarak işaretlendiğini belirtmek için kullanılır.
- @GeneatedValue anotation ile birlikte kullanılır


```Java
public class Todo {
    @Id     // Veritabanında primary key olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Veritabanında auto increment olduğunu belirtir
    @Column(name = "id")
    private int id;

```
