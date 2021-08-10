package hipshop;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hipshop.models.Album;
import hipshop.models.Card;
import hipshop.models.Clothing;
import hipshop.models.ClothingType;
import hipshop.models.Favorite;
import hipshop.models.Following;
import hipshop.models.HipHopBranch;
import hipshop.models.Product;
import hipshop.models.PurchaseOrder;
import hipshop.models.PurchaseOrderItem;
import hipshop.models.Workshop;
import hipshop.models.Song;
import hipshop.models.Member;
import hipshop.repositories.AlbumRepository;
import hipshop.repositories.ClothingRepository;
import hipshop.repositories.FavoriteRepository;
import hipshop.repositories.FollowingRepository;
import hipshop.repositories.ProductRepository;
import hipshop.repositories.PurchaseOrderRepository;
import hipshop.repositories.WorkshopRepository;
import hipshop.repositories.SongRepository;
import hipshop.repositories.MemberRepository;
import hipshop.repositories.CardRepository;
import hipshop.repositories.PurchaseOrderItemRepository;

@SpringBootApplication
public class HipSHopApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(HipSHopApplication.class, args);
	}
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SongRepository songRepository;
	@Autowired
	private MemberRepository userRepository;
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	@Autowired
	private PurchaseOrderItemRepository purchaseOrderItemRepository;
	@Autowired
	private FollowingRepository followingRepository;
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting...");
		
		BigDecimal precio = new BigDecimal("100");
		Date fecha = new Date();
		Workshop serviceOne = new Workshop ("Rap y derechos", "https://elniniorizoma.files.wordpress.com/2016/02/12746591_10153962927037002_551030463_n-11.jpg", precio , fecha , "Ciudad de México");
		Product product = new Product(serviceOne, member, HipHopBranch.RapFreestyle);
		productRepository.save(product);
		
		BigDecimal precio1 = new BigDecimal ("150");
		Date fecha1 = new Date();
		Workshop serviceTwo = new Workshop ("Poesía y rap femenil", "https://rapfeminista.files.wordpress.com/2018/05/31841498_1511154082344324_2930540199916077056_n.jpg?w=640", precio1 , fecha1, "Faro Tláhuac");
		Product product1 = new Product(serviceTwo, member, HipHopBranch.RapFreestyle);
		productRepository.save(product1);
		
		BigDecimal precio2 = new BigDecimal ("500");
		Date fecha2 = new Date();
		Workshop serviceThree = new Workshop ("Freedom on the mic", "https://get.google.com/albumarchive/104995706740150662008/album/AF1QipPGeo5K46fpYv8RUVI2NC6c0N8L3TUSR-7ZZWCj/AF1QipM7l-y40a-72vM7d5JnKSoWIOaYzDlZGeA8y3TJ?hl=es", precio2 , fecha2, "Evento virtual para todo el mundo");
		Product product2 = new Product(serviceThree, member, HipHopBranch.RapFreestyle);
		productRepository.save(product2);
		
		
		BigDecimal precio3 = new BigDecimal ("370");
		Integer cantidad = 30;
		Clothing clothOne = new Clothing ("Playera", precio3, "123ksifdos", "#000", "mediana", cantidad , "unisex", ClothingType.TShirt, "https://images.pexels.com/photos/2342585/pexels-photo-2342585.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
		Product product3 = new Product(clothOne, member, HipHopBranch.Graffiti);
		productRepository.save(product3);
		
		
		BigDecimal precio4 = new BigDecimal ("470");
		Integer cantidad1 = 15;
		Clothing clothTwo = new Clothing ("Conjunto casual", precio4, "grs873", "#ff8000", "chico", cantidad1, "unisex", ClothingType.Hoodies, "https://images.pexels.com/photos/7969702/pexels-photo-7969702.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
		Product product4 = new Product(clothTwo, member, HipHopBranch.Breaking);
		productRepository.save(product4);
		
		BigDecimal precio5 = new BigDecimal ("385");
		Integer cantidad2 = 22;
		Clothing clothThree = new Clothing ("Conjunto casual",precio5, "pls986", "#9b9b9b", "grande", cantidad2, "unisex", ClothingType.TShirt, "https://images.pexels.com/photos/4734656/pexels-photo-4734656.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
		Product product5 = new Product(clothThree, member, HipHopBranch.DJBeatmaker);
		productRepository.save(product5);
		
		BigDecimal precio6 = new BigDecimal ("420");
		Date fecha3 = new Date();
		Workshop serviceFour = new Workshop ("Taller de Beatbox", "https://ocioalmeria.es/wp-content/uploads/Taller-de-BeatBox-con-David-Galera.jpg", precio6 , fecha3, "Morelia");
		Product product6 = new Product(serviceFour, member, HipHopBranch.DJBeatmaker);
		productRepository.save(product6);

		BigDecimal precio7 = new BigDecimal ("1300");
		Integer cantidad3 = 8;
		Clothing clothFour = new Clothing ("Tennis",precio5, "usys97346", "#FFFFFF", "mediano", cantidad3, "unisex", ClothingType.Shoes, "https://images.pexels.com/photos/8028106/pexels-photo-8028106.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260");
		Product product7 = new Product(clothFour, member, HipHopBranch.Breaking);
		productRepository.save(product7);
		
		BigDecimal precio8 = new BigDecimal ("1300");
		Integer cantidad4 = 28;
		Clothing clothFive = new Clothing ("Hoodie con capucha",precio8, "iosjs8846", "#FFFFFF", "chico", cantidad4, "unisex", ClothingType.Hoodies, "https://images.pexels.com/photos/7955541/pexels-photo-7955541.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
		Product product8 = new Product(clothFive, member, HipHopBranch.Graffiti);
		productRepository.save(product8);
		
		BigDecimal precio9 = new BigDecimal ("200");
		Date fecha4 = new Date();
		Workshop serviceFive = new Workshop ("Taller de Beats", "https://harinerazgz.files.wordpress.com/2019/08/cartel-aitor-2020.jpg", precio9, fecha4, "Zaragoza");
		Product product9 = new Product(serviceFive, member, HipHopBranch.DJBeatmaker);
		productRepository.save(product9);
		
		/*BigDecimal precio = new BigDecimal("10");
		
		Album album1 = new Album("First name album", precio);
		
		Clothing clothe1 = new Clothing("First name Cloth",precio);
		
		Workshop service1 = new Workshop("First name service", precio);
		
		Song song1 = new Song("Song 1", album1);
		Song song2 = new Song("Song 2", album1);
		Song song3 = new Song("Song 3", album1);
		
		
		Member vendor1 = userRepository.findById(2L).get();
		Member vendor2 = userRepository.findById(3L).get();
		Member vendor3 = userRepository.findById(4L).get();
		
		
		Product product1 = new Product(album1, vendor1);
		Product product2 = new Product(clothe1, vendor2);
		Product product3 = new Product(service1, vendor3);
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		songRepository.save(song1);
		songRepository.save(song2);
		songRepository.save(song3);
		*/
		
		/*BigDecimal precio = new BigDecimal("10");
		
		Album album1 = new Album("First name album", precio);
		
		Clothing clothe1 = new Clothing("First name Cloth",precio);
		
		Workshop service1 = new Workshop("First name service", precio);
		
		Song song1 = new Song("Song 1", album1);
		Song song2 = new Song("Song 2", album1);
		Song song3 = new Song("Song 3", album1);
		
		
		Vendor vendor1 = new Vendor("First Vendor");
		Vendor vendor2 = new Vendor("second Vendor");
		
		vendorRepository.save(vendor1);
		vendorRepository.save(vendor2);
		
		Product product1 = new Product(album1, vendor1);
		Product product2 = new Product(clothe1, vendor2);
		Product product3 = new Product(service1, vendor1);
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		songRepository.save(song1);
		songRepository.save(song2);
		songRepository.save(song3);
		
		
		
		
		
		Card card1 = new Card(user1, "first user card");
		Card card2 = new Card(user2, "second user card");
		
		cardRepository.save(card1);
		cardRepository.save(card2);
		
		PurchaseOrder purchase1 = new PurchaseOrder(10f, user1);
		
		PurchaseOrderItem item1 = new PurchaseOrderItem(purchase1, product1, precio);
		PurchaseOrderItem item2 = new PurchaseOrderItem(purchase1, product2, precio);
		
		purchaseOrderRepository.save(purchase1);
		purchaseOrderItemRepository.save(item1);
		purchaseOrderItemRepository.save(item2);
		
		Following follow1 = new Following(vendor1, user1);
		Following follow2 = new Following(vendor1, user2);
		Following follow3 = new Following(vendor2, user1);
		followingRepository.save(follow1);
		followingRepository.save(follow2);
		followingRepository.save(follow3);
		
		Favorite favorite1 = new Favorite(product1, user1);
		Favorite favorite2 = new Favorite(product2, user1);
		Favorite favorite3 = new Favorite(product3, user1);
		Favorite favorite4 = new Favorite(product1, user2);
		Favorite favorite5 = new Favorite(product2, user2);
		Favorite favorite6 = new Favorite(product3, user2);
		favoriteRepository.save(favorite1);
		favoriteRepository.save(favorite2);
		favoriteRepository.save(favorite3);
		favoriteRepository.save(favorite4);
		favoriteRepository.save(favorite5);
		favoriteRepository.save(favorite6);*/
	}

}
