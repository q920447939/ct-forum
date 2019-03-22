/**
 * @Project:
 * @Author: leegoo
 * @Date: 2019年03月20日
 */
package cn.withmes.ct.forum.topic.test;

/**
 * ClassName: TestController
 *
 * @author leegoo
 * @Description:
 * @date 2019年03月20日
 */
/*
@Deprecated
@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class TestController {
    static Map<Long, Topic> users = Collections.synchronizedMap(new HashMap<Long, Topic>());

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Topic> getUserList() {
        List<Topic> r = new ArrayList<Topic>(users.values());
        return r;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestBody Topic user) {
        users.put(111L, user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Topic getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody Topic user) {
        Topic u = users.get(id);
        u.setComments(11);
        u.setContent("222");
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
*/
