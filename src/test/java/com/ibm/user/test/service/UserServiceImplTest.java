package com.ibm.user.test.service;

//public class UserServiceImplTest {
//
//	@Mock
//	UserRepository userRepository;
//
//	User user;
//
//	@InjectMocks
//	UserServiceImpl userService;
//
//	List<User> userList = null;
//	Optional<User> options;
//
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//
//		user = new User();
//		user = new User();
//		user.setId("JohnS2");
//		user.setFirstName("John");
//		user.setLastName("Simon");
//		user.setUserName("Simon");
//		user.setContactNumber("9898989898");
//		user.setPassword("123456");
//		user.setCreatedDate(new Date());
//		userList = new ArrayList<>();
//		userList.add(user);
//
//		options = Optional.of(user);
//
//	}
//
//	@Test
//	public void registerUserSuccess() throws UserAlreadyExistsException {
//		when(userRepository.save((User) any())).thenReturn(user);
//		String userSaved = userService.registerUser(user);
//		assertEquals("success", userSaved);
//
//	}
//
//	//@Test(expected = UserAlreadyExistsException.class)
//	public void registerUserFailure() throws UserAlreadyExistsException {
//		when(userRepository.save((User) any())).thenReturn(null);
//		String userSaved = userService.registerUser(user);
//		assertEquals("failure", userSaved);
//
//	}
//
//}