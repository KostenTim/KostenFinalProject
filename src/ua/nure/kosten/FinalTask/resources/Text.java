package ua.nure.kosten.FinalTask.resources;

public class Text {
	private String lg = "eng";
	private String login = "Login";
	private String password = "Password";
	private String translate = "translate";
	private String sign_in = "Sign In";
	private String registration = "Registration";
	private String home_page = "HOME PAGE";
	private String confirm_password = "Confirm password";
	private String logout = "LogOut";
	private String showTickets = "SHOW TICKETS";
	private String FIND = "FIND";
	private String result_find_from = "Result find from";
	private String view_train_route_information_by_train_number = "View train route information by train number";
	private String SHOW_INFO = "SHOW INFO";
	private String buy_train_ticket_number = "Buy train ticket number";
	private String place = "place";
	private String compartment_train = "compartment train";
	private String sleeper_train = "sleeper train";
	private String train_carriage = "train carriage";
	private String BUY = "BUY";
	private String rain_N = "rain №";
	private String date_time_of_departure = "date/time of departure";
	private String departure_station = "departure station";
	private String travel_time = "travel time(min)";
	private String date_time_of_arrival = "date/time of arrival";
	private String arrival_station = "arrival station";
	private String book_compartment_train = "book compartment train";
	private String prices_compartment_train = "prices compartment train";
	private String book_sleeper_train = "book sleeper train";
	private String prices_sleeper_train = "prices sleeper train";
	private String book_train_carriage = "book train carriage";
	private String prices_train_carriage = "prices train carriage";
	private String name_station = "name station";
	private String stop_time = "stop time";
	private String SHOW_USERS = "SHOW USERS";
	private String SHOW_ALL_WAYS = "SHOW ALL WAYS";
	private String role = "Role";
	private String list_of_all_routes_in_the_database = "List of all routes in the database";
	private String route_N = "route №";
	private String EDIT = "EDIT";
	private String route = "Route";
	private String the_route_passes_through_the_station_data = "The route passes through the station data";
	private String station = "Station";
	private String DELETE = "DELETE";
	private String STOP_TIME_MIN = "STOP TIME (MIN)";
	private String CHANGE = "CHANGE";
	private String ADD = "ADD";
	private String you_do_not_have_access_rights = "You do not have access rights";
	private String ticket_N = "ticket №";
	private String cost = "cost";
	private String you_have_no_tickets = "You have no tickets";
	

	public Text(String leng) {
		if ("rus".equals(leng)) {
			this.lg = "rus";
			this.login = "Логин";
			this.password = "Пароль";
			this.translate = "перевести";
			this.sign_in = "Войти";
			this.registration = "Регистрация";
			this.home_page = "ГЛАВНАЯ СТРАНИЦА";
			this.confirm_password = "Повторите пароль";
			this.logout = "ВЫЙТИ";
			this.showTickets = "БИЛЕТЫ";
			this.FIND = "НАЙТИ";
			this.result_find_from = "Результат поиска";
			this.view_train_route_information_by_train_number = "Просмотр информации о маршруте поезда";
			this.SHOW_INFO = "ПОКАЗАТЬ ИНФОРМАЦИЮ";
			this.buy_train_ticket_number = "Купить билет на поезд";
			this.place = "место";
			this.compartment_train = "купе";
			this.sleeper_train = "плацкард";
			this.train_carriage = "общий вагон";
			this.BUY = "КУПИТЬ";
			this.rain_N = "номер поезда";
			this.date_time_of_departure = "дата/время отправления";
			this.departure_station = "станция отправления";
			this.travel_time = "время в пути(мин)";
			this.date_time_of_arrival = "дата/время прибытия";
			this.arrival_station = "станция прибытия";
			this.book_compartment_train = "свободных мест купе";
			this.prices_compartment_train = "стоимость купе";
			this.book_sleeper_train = "свободных мест плацкард";
			this.prices_sleeper_train = "стоимость плацкард";
			this.book_train_carriage = "свободных общих мест";
			this.prices_train_carriage = "стоимость общего места";
			this.name_station = "название станции";
			this.stop_time = "время остановки";
			this.SHOW_USERS = "ПОЛЬЗОВАТЕЛИ";
			this.SHOW_ALL_WAYS = "СПИСОК ВСЕХ РЕЙСОВ";
			this.role = "Роль";
			this.list_of_all_routes_in_the_database = "Список всех рейсов в базе";
			this.route_N = "номер рейса";
			this.EDIT = "РЕДАКТИРОВАТЬ";
			this.route = "Рейс";
			this.the_route_passes_through_the_station_data = "Маршрут проходит через данные станции";
			this.station = "Станцию";
			this.DELETE = "УДАЛИТЬ";
			this.STOP_TIME_MIN = "ВРЕМЯ ОСТАНОВКИ (МИН)";
			this.CHANGE = "ИЗМЕНИТЬ";
			this.ADD = "ДОБАВИТЬ";
			this.you_do_not_have_access_rights = "У вас нет прав доступа";
			this.ticket_N = "номер билета";
			this.cost = "стоимость";
			this.you_have_no_tickets = "У вас нет билетов";
		}
	}
	public String gethome_page() {
		return home_page;
	}
	public void sethome_page(String hOME_PAGE) {
		home_page = hOME_PAGE;
	}
	public String getRole() {
		return role;
	}
	public String getRoute() {
		return route;
	}
	public String getYou_have_no_tickets() {
		return you_have_no_tickets;
	}
	public void setYou_have_no_tickets(String you_have_no_tickets) {
		this.you_have_no_tickets = you_have_no_tickets;
	}
	public String getYou_do_not_have_access_rights() {
		return you_do_not_have_access_rights;
	}
	public String getTicket_N() {
		return ticket_N;
	}
	public void setTicket_N(String ticket_N) {
		this.ticket_N = ticket_N;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public void setYou_do_not_have_access_rights(String you_do_not_have_access_rights) {
		this.you_do_not_have_access_rights = you_do_not_have_access_rights;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getThe_route_passes_through_the_station_data() {
		return the_route_passes_through_the_station_data;
	}
	public void setThe_route_passes_through_the_station_data(String the_route_passes_through_the_station_data) {
		this.the_route_passes_through_the_station_data = the_route_passes_through_the_station_data;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getDELETE() {
		return DELETE;
	}
	public void setDELETE(String dELETE) {
		DELETE = dELETE;
	}
	public String getSTOP_TIME_MIN() {
		return STOP_TIME_MIN;
	}
	public void setSTOP_TIME_MIN(String sTOP_TIME_MIN) {
		STOP_TIME_MIN = sTOP_TIME_MIN;
	}
	public String getCHANGE() {
		return CHANGE;
	}
	public void setCHANGE(String cHANGE) {
		CHANGE = cHANGE;
	}
	public String getADD() {
		return ADD;
	}
	public void setADD(String aDD) {
		ADD = aDD;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getList_of_all_routes_in_the_database() {
		return list_of_all_routes_in_the_database;
	}
	public void setList_of_all_routes_in_the_database(String list_of_all_routes_in_the_database) {
		this.list_of_all_routes_in_the_database = list_of_all_routes_in_the_database;
	}
	public String getRoute_N() {
		return route_N;
	}
	public void setRoute_N(String route_N) {
		this.route_N = route_N;
	}
	public String getEDIT() {
		return EDIT;
	}
	public void setEDIT(String eDIT) {
		EDIT = eDIT;
	}
	public String getSHOW_USERS() {
		return SHOW_USERS;
	}
	public void setSHOW_USERS(String sHOW_USERS) {
		SHOW_USERS = sHOW_USERS;
	}
	public String getSHOW_ALL_WAYS() {
		return SHOW_ALL_WAYS;
	}
	public void setSHOW_ALL_WAYS(String sHOW_ALL_WAYS) {
		SHOW_ALL_WAYS = sHOW_ALL_WAYS;
	}
	public String getLogout() {
		return logout;
	}
	public void setLogout(String logout) {
		this.logout = logout;
	}
	public String getShowTickets() {
		return showTickets;
	}
	public String getName_station() {
		return name_station;
	}
	public void setName_station(String name_station) {
		this.name_station = name_station;
	}
	public String getStop_time() {
		return stop_time;
	}
	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}
	public void setShowTickets(String showTickets) {
		this.showTickets = showTickets;
	}
	public String getFIND() {
		return FIND;
	}
	public String getRain_N() {
		return rain_N;
	}
	public void setRain_N(String rain_N) {
		this.rain_N = rain_N;
	}
	public String getDate_time_of_departure() {
		return date_time_of_departure;
	}
	public void setDate_time_of_departure(String date_time_of_departure) {
		this.date_time_of_departure = date_time_of_departure;
	}
	public String getDeparture_station() {
		return departure_station;
	}
	public void setDeparture_station(String departure_station) {
		this.departure_station = departure_station;
	}
	public String getTravel_time() {
		return travel_time;
	}
	public void setTravel_time(String travel_time) {
		this.travel_time = travel_time;
	}
	public String getDate_time_of_arrival() {
		return date_time_of_arrival;
	}
	public void setDate_time_of_arrival(String date_time_of_arrival) {
		this.date_time_of_arrival = date_time_of_arrival;
	}
	public String getArrival_station() {
		return arrival_station;
	}
	public void setArrival_station(String arrival_station) {
		this.arrival_station = arrival_station;
	}
	public String getBook_compartment_train() {
		return book_compartment_train;
	}
	public void setBook_compartment_train(String book_compartment_train) {
		this.book_compartment_train = book_compartment_train;
	}
	public String getPrices_compartment_train() {
		return prices_compartment_train;
	}
	public void setPrices_compartment_train(String prices_compartment_train) {
		this.prices_compartment_train = prices_compartment_train;
	}
	public String getBook_sleeper_train() {
		return book_sleeper_train;
	}
	public void setBook_sleeper_train(String book_sleeper_train) {
		this.book_sleeper_train = book_sleeper_train;
	}
	public String getPrices_sleeper_train() {
		return prices_sleeper_train;
	}
	public void setPrices_sleeper_train(String prices_sleeper_train) {
		this.prices_sleeper_train = prices_sleeper_train;
	}
	public String getBook_train_carriage() {
		return book_train_carriage;
	}
	public void setBook_train_carriage(String book_train_carriage) {
		this.book_train_carriage = book_train_carriage;
	}
	public String getPrices_train_carriage() {
		return prices_train_carriage;
	}
	public void setPrices_train_carriage(String prices_train_carriage) {
		this.prices_train_carriage = prices_train_carriage;
	}
	public void setFIND(String fIND) {
		FIND = fIND;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getSign_in() {
		return sign_in;
	}
	public String getHome_page() {
		return home_page;
	}
	public void setHome_page(String home_page) {
		this.home_page = home_page;
	}
	public String getResult_find_from() {
		return result_find_from;
	}
	public void setResult_find_from(String result_find_from) {
		this.result_find_from = result_find_from;
	}
	public String getView_train_route_information_by_train_number() {
		return view_train_route_information_by_train_number;
	}
	public void setView_train_route_information_by_train_number(String view_train_route_information_by_train_number) {
		this.view_train_route_information_by_train_number = view_train_route_information_by_train_number;
	}
	public String getSHOW_INFO() {
		return SHOW_INFO;
	}
	public void setSHOW_INFO(String sHOW_INFO) {
		SHOW_INFO = sHOW_INFO;
	}
	public String getBuy_train_ticket_number() {
		return buy_train_ticket_number;
	}
	public void setBuy_train_ticket_number(String buy_train_ticket_number) {
		buy_train_ticket_number = buy_train_ticket_number;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCompartment_train() {
		return compartment_train;
	}
	public void setCompartment_train(String compartment_train) {
		this.compartment_train = compartment_train;
	}
	public String getSleeper_train() {
		return sleeper_train;
	}
	public void setSleeper_train(String sleeper_train) {
		this.sleeper_train = sleeper_train;
	}
	public String getTrain_carriage() {
		return train_carriage;
	}
	public void setTrain_carriage(String train_carriage) {
		this.train_carriage = train_carriage;
	}
	public String getBUY() {
		return BUY;
	}
	public void setBUY(String bUY) {
		BUY = bUY;
	}
	public void setSign_in(String sign_in) {
		this.sign_in = sign_in;
	}
	public String getLg() {
		return lg;
	}
	public void setLg(String lg) {
		this.lg = lg;
	}
	public String getTranslate() {
		return translate;
	}
	public void setTranslate(String translate) {
		this.translate = translate;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
