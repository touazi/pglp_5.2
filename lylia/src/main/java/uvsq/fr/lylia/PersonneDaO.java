package uvsq.fr.lylia;

import java.io.Serializable;

public class PersonneDaO<T extends Serializable> extends Serialization<PERSONNE> implements DAO<PERSONNE> {

	@Override
	public PERSONNE create(PERSONNE obj) {
		// TODO Auto-generated method stub
		return createFile(obj, obj.getNom());
	}

	@Override
	public PERSONNE read(String id) {
		// TODO Auto-generated method stub
		return readFile(id);
	}

	@Override
	public PERSONNE update(PERSONNE obj) {
		// TODO Auto-generated method stub
		return updateFile(obj, obj.getNom());
	}

	@Override
	public void delete(PERSONNE obj) {
		// TODO Auto-generated method stub
		deleteFile(obj.getNom());
	}

}
