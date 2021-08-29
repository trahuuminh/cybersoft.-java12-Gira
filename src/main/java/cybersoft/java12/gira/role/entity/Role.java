package cybersoft.java12.gira.role.entity;



import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.java12.gira.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"groups","programs"})
@EqualsAndHashCode(exclude = {"groups","programs"},callSuper = false)
@Entity
@Table(name = "gira_role")
public class Role extends BaseEntity {
	@NotNull
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;
	
	
	private String description;
	
	@JsonIgnore
	@Builder.Default
	@ManyToMany(mappedBy = "roles")
	private Set<Group> groups = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "gira_role_program",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "program_id")
	)
	@Builder.Default
	private Set<Program> programs = new HashSet<>();

	/*
	 *Các lưu ý khi thiết lập 1 quan hệ many to many
	 *1. xác định chủ quan hệ 
	 *2. dùng Set, không sử dụng list
	 *3. Tránh sử dụng CascadeType ALL và REMOVE 
	 *4. Fetching lazy cả 2 chiều của quan hệ 
	 *5. thiết lập Join Table
	 *6. Giữ sự liên kết giữu các quan hệ này đồng bộ
	 */
	
	public void addProgram(Program program) {
		this.programs.add(program);
		program.getRoles().add(this);
	}
	
	public void removeProgram(Program program) {
		this.programs.remove(program);
		program.getRoles().remove(this);
	}
	
	
	
	
}