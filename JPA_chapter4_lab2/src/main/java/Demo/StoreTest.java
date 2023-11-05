package Demo;

import dao.StoreDao;
import entity.Address;
import entity.Contact;
import entity.Store;
/*
20043331
Lê Trần Tú Uyên
*/
public class StoreTest {

	public static void main(String[] args) {
		StoreDao storeDao = new StoreDao();
		Contact contact = new Contact("234234234", "abcxyz@gmail.com");
		Address address  = new Address("abc", "xyz", "mnp", "hhuh");
		Store store = new Store("abc", contact, address);
		
		Store store1 = new Store("kkk", contact, address);
		Store store2 = new Store("kkk", contact, address);
		
		storeDao.addStore(store);
		storeDao.addStore(store1);
		
		storeDao.deleteStore(2);

		store.setName("silent");
		storeDao.updateStore(store1);
		
		storeDao.getAll().forEach(st->System.out.println(st));
				
	}
}
