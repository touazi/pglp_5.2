package uvsq.fr.lylia;

import java.io.Serializable;

public class GroupeDao <T extends Serializable> extends Serialization<GroupePersonnel> implements DAO<GroupePersonnel> {

	@Override
	public GroupePersonnel create(GroupePersonnel obj) {
		// TODO Auto-generated method stub
		return createFile(obj, obj.getId());
	}

	@Override
	public GroupePersonnel read(String id) {
		// TODO Auto-generated method stub
		return readFile(id);
	}

	@Override
	public GroupePersonnel update(GroupePersonnel obj) {
		// TODO Auto-generated method stub
		return updateFile(obj, obj.getId());
	}

	@Override
	public void delete(GroupePersonnel obj) {
		// TODO Auto-generated method stub
		deleteFile(obj.getId());
		
	}

}
