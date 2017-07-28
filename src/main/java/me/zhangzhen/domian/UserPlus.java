package me.zhangzhen.domian;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("user_plus")
public class UserPlus extends Model<UserPlus> implements Serializable {

    /** 用户ID */
    private Long id;

    /** 用户名 */
    private String name;

    /** 用户年龄 */
    private Integer age;

//    @TableField(exist = false)
    private String state;
    
    public UserPlus (){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "UserPlus [id=" + id + ", name=" + name + ", age=" + age + ", state=" + state + "]";
	}

	public UserPlus(Long id, String name, Integer age, String state) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.state = state;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}
    
    
}