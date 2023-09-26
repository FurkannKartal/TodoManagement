# TodoManagement

## Annotations

### JPA Annotations

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

## Lombok Annotations

#### @Data:

<ul>
<li>@Getter</li>
<li>@Setter</li>
<li>@RequiredArgsConstructor</li>
</ul>

- Bu annotation yukarıda belirtilen özellikleri birarada kullanmamızı sağlayan bir kısayoldur.


---

#### @NoArgsConstructor:

- Parametresiz Constructor oluşturur.

---

#### @AllArgsConstructor:

- Parametreli Constructor oluşturur

---

#### @Getter:

- Sınıftaki her alan için getter methodu oluşturur.


---

#### @Setter:

- Sınıftaki her alan için setter methodu oluşturur.

---

### Spring Annotations

#### @Repository :

- Sınıf seviyesinde bir annotation.
- Veritabanına erişip işlemler yapabilir.
- Veritabanı ve service arasındaki bağlantıyı kurar.
- DAO bir repositorydir.(??????????)


```java
@Repository
public class TodoRepository implements  ITodoRepository{
    List<Todo> todos;

    public TodoRepository() {
        todos = new ArrayList<>();
        todos.add(new Todo(1,"Furkan","Ogrenci",true));
        todos.add(new Todo(2,"Fatih","Ogrenci",false));
        todos.add(new Todo(3,"Zeynep","Ogretmen",true));
        todos.add(new Todo(4,"Gulcan","Ogretmen",false));
        todos.add(new Todo(5,"Seda","Ogrenci",true));

    }
```


#### @Service :

- Sınıf seviyesinde bir annotation.
- Bir service katmanıdır.
- Bir service oluşturmak için kullanılır.
- Busines logictir.(???????)


```java
@Service
public class TodoService implements ITodoService {
    private ITodoRepository todoRepository;
}
```

---

#### @Autowired :

- Alan bazlı bir annotation.
- Dependenciesi enjekte etmek için kullanılır.
- Nesneyi enjekte etmek için kullanılır.

**** Buna bak ?????????

```java
public class Todo{
   private int id;
   private String name;

   @Autowired
   public Tood(int id, String name){
     this.id = id;
     this.name = name;
   }
}

```

---

#### @Controller :

- Sınıf katında bir annotation.
- Controller olduğunu belirtmek için kullanılır.
- @RequestMapping ile birlikte kullanılır.

```java
@Controller
@RequestMapping("/api/todos")
public class TodoController{
   
}
```


#### @RequestMapping :

- Method seviyesinde annotation
- HTTP isteğini belirli bir yöntemle eşlemek için kullanılır.

```java
@Controller
@RequestMapping("/api/todos")
public class TodoController {
}
```


---

#### @GetMapping :

- Method seviyesinde Annotation
- HTTP isteğini belirli bir yöntemle eşlemek için kullanılır.
- Datayı okumak ve çekmek için kullanılır


```java
  @GetMapping("/getall")
    public List<GetAllTodosResponse> getAll() {
        return todoService.getAll();
    }
```

#### @PostMapping :

- Method seviyesinde Annotation
- HTTP isteğini belirli bir yöntemle eşlemek için kullanılır.
- Data oluşturup eklemek için kullanılır


```java
 @PostMapping("/add")
    public void add(CreateTodosRequest createTodosRequest) {    //@Requestbody e bak ??????
        this.todoService.add(createTodosRequest);
    }
```

---

#### @PutMapping :

- Method seviyesinde Annotation
- HTTP isteğini belirli bir yöntemle eşlemek için kullanılır.
- Datayı update etmek için kullanılır.


```java
  @PutMapping("/update")
    public void update(UpdateTodosRequest updateTodosRequest) {
        todoService.update(updateTodosRequest);
    }
  }
```

---

#### @DeleteMapping :

- Method seviyesinde Annotation
- HTTP isteğini belirli bir yöntemle eşlemek için kullanılır.
- Datayı silmek için kullanılır.


```java
  @DeleteMapping("/delete")
  public void delete(@RequestBody Brand brand){
      brandService.delete(brand);
  }
```




























