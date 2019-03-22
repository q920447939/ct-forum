1,spring-boot 加上@RestController 不起作用或者报错
    `The DispatcherServlet configuration needs to include a HandlerAdapter that supports th`
    

解决方法一:尝试加上`@RestController`+`@RequestMapping`

```java
@RestController
@RequestMapping("/topic")
```

2,报错`No serializer found for class java.lang.Object and no properties discovered to create BeanSerializer `
    我的解决办法是发现bean copy的时候,bean里面还有bean  如下,此时属性records由于是泛型导致我项目中使用的copy会丢失类型,于是返回json解析的时候就会报错,所以重新设置一下records属性值就行了
```java
    public class Page<T> implements IPage<T> {
        private List<T> records;
    }
    //do something
    
    IPage<TopicVO> vos = CopyAttributesUtils.copyAtoB(pageList, IPage.class);
    vos.setRecords(CopyAttributesUtils.copyAlistToBlist(pageList.getRecords(), TopicVO.class));
    //此时如果进行vos的json转化就会报错,debug也会发现records的值是异常的         
```

