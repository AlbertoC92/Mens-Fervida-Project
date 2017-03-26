DROP TABLE IF EXISTS "SPANISH";
CREATE TABLE "SPANISH" (
	`WORD`	TEXT NOT NULL,
	`TL1`	TEXT NOT NULL,
	`TL2`	TEXT,
	`TL3`	TEXT,
	`NIVEL`	INTEGER NOT NULL,
	`TIPO`	TEXT NOT NULL
);
INSERT INTO `SPANISH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('anchovy','boquerón','anchoa','',1,'food'),
 ('Apple','Manzana','','',1,'food'),
 ('Banana','Plátano','Banana','',1,'food'),
 ('beer','cerveza','','',1,'food'),
 ('bread','pan','','',1,'food'),
 ('Burger','hamburguesa','','',1,'food'),
 ('Cherries','Cerezas','','',1,'food'),
 ('Cherry','Cereza','','',1,'food'),
 ('Chicken','pollo','','',1,'food'),
 ('chickpea','garbanzo','','',1,'food'),
 ('cod','bacalao','','',1,'food'),
 ('Eggs','huevos','','',1,'food'),
 ('Garlic','Ajo','','',1,'food'),
 ('green beans','judías verdes','','',1,'food'),
 ('hake','merluza','pescada','',1,'food'),
 ('juice','zumo','','',1,'food'),
 ('macaroni','macarrones','','',1,'food'),
 ('noodles','fideos','','',1,'food'),
 ('Onion','Cebolla','','',1,'food'),
 ('Papaya','Papaya','','',1,'food'),
 ('Pear','Pera','','',1,'food'),
 ('potage','potaje','','',1,'food'),
 ('proteins','proteínas','','',1,'food'),
 ('pumpkin','calabaza','','',1,'food'),
 ('Ravioli','raviolis','','',1,'food'),
 ('Soup','sopa','','',1,'food'),
 ('spaghetti','espaguetis','','',1,'food'),
 ('squid','calamar','','',1,'food'),
 ('Strawberry','Fresa','','',1,'food'),
 ('swordfish','emperador','','',1,'food'),
 ('Tiramisu','tiramisú','','',1,'food'),
 ('Tomato','Tomate','','',1,'food'),
 ('trout','trucha','','',1,'food'),
 ('Turkey','pavo','','',1,'food'),
 ('Vegetable','Vegetal','Verdura','',1,'food'),
 ('Water','agua','','',1,'food'),
 ('wholemeal bread','pan integral','','',1,'food'),
 ('cabbage','repollo','','',1,'food'),
 ('calories','calorías','','',1,'food'),
 ('Carrot','Zanahoria','','',1,'food'),
 ('cauliflower','Coliflor','','',1,'food'),
 ('cheese','queso','','',1,'food'),
 ('chips','patatas fritas','','',1,'food'),
 ('clams','almejas','','',1,'food'),
 ('Empanadillas','empanadillas','','',1,'food'),
 ('endive','escarola','','',1,'food'),
 ('fat','grasas','gordo','',1,'food'),
 ('green peas','guisantes','','',1,'food'),
 ('Lamb','cordero','','',1,'food'),
 ('lentils','lentejas','','',1,'food'),
 ('Lettuce','Lechuga','','',1,'food'),
 ('lobster','langosta','','',1,'food'),
 ('mussels','mejillones','','',1,'food'),
 ('omelette','tortilla francesa','tortilla','',1,'food'),
 ('Peach','Melocotón','','',1,'food'),
 ('Plum','Ciruela','','',1,'food'),
 ('Pork','cerdo','','',1,'food'),
 ('prawns','gambas','','',1,'food'),
 ('rabbit','conejo','','',1,'food'),
 ('Red pepper','Pimiento rojo','','',1,'food'),
 ('rice','arroz','','',1,'food'),
 ('rice pudding','arroz con leche','','',1,'food'),
 ('sardine','sardina','','',1,'food'),
 ('Spanish omelette','tortilla de patatas','','',1,'food'),
 ('Spinach','Espinacas','','',1,'food'),
 ('Tortelini','tortelini','','',1,'food'),
 ('Watermelon','Sandía','Melón de agua','',1,'food'),
 ('wine','vino','','',1,'food'),
 ('Zucchini','Calabacín','','',1,'food'),
 ('pepper','pimienta','','',1,'food'),
 ('Avocado','Aguacate','','',2,'food'),
 ('Biscuit','bizcocho','galleta','',2,'food'),
 ('biscuits','galletas','','',2,'food'),
 ('Cantaloupe','Melón','','',2,'food'),
 ('chard','Acelgas','','',2,'food'),
 ('Cooked','cocido','','',2,'food'),
 ('eggplant','Berenjena','','',2,'food'),
 ('football','fútbol','balonpié','',2,'food'),
 ('green pepper','Pimiento verde','','',2,'food'),
 ('handball','balónmano','','',2,'food'),
 ('Leek','Puerro','','',2,'food'),
 ('red mullets','salmonetes','','',2,'food'),
 ('red sea bream','besugo','','',2,'food'),
 ('rye','centeno','','',2,'food'),
 ('sausage','salchichón','chorizo','salchichas',2,'food'),
 ('stop watch','cronómetro','','',2,'food'),
 ('turnip','Nabo','','',2,'food'),
 ('Veal','ternera','','',2,'food'),
 ('vitamins','vitaminas','','',2,'food'),
 ('alfalfa','alfalfa','','',2,'food'),
 ('aniseed','anís','','',2,'food'),
 ('cayenne','pimienta de cayena','cayena','',2,'food'),
 ('rosemary','romero','','',2,'food'),
 ('candies','caramelos','','',2,'food'),
 ('carbohydrates','hidratos de carbono','carbohidratos','',2,'food'),
 ('Cranberry','Arándano','','',2,'food'),
 ('Ham','jamón','','',2,'food'),
 ('minerals','minerales','','',2,'food'),
 ('muffin','magdalenas','','',2,'food'),
 ('snack','bocadillo','','',2,'food'),
 ('York ham','jamón york','','',2,'food'),
 ('mint','menta','','',2,'food'),
 ('nutmeg','nuez moscada','','',2,'food'),
 ('valerian','valeriana','','',2,'food'),
 ('crabs','cangrejos','','',3,'food'),
 ('Steaks','filetes','','',3,'food'),
 ('drinks','refrescos','','',3,'food'),
 ('mortadella','mortadela','','',3,'food'),
 ('Raspberry','Frambuesa','','',3,'food'),
 ('salmon','salmón','','',3,'food'),
 ('lemongrass','citronela','','',3,'food'),
 ('paprika','pimentón','','',3,'food'),
 ('loin','lomo','','',4,'food'),
 ('vegetables cream','crema de verduras','','',4,'food'),
 ('saffron','azafrán','','',4,'food'),
 ('coriander','cilantro','','',4,'food'),
 ('parsley','perejil','','',4,'food'),
 ('clover','trébol','','',4,'food'),
 ('red clover','trébol rojo','','',4,'food'),
 ('custard','natilllas','','',4,'food'),
 ('Neapolitan','napolitana','','',4,'food'),
 ('Patty','empanada','','',4,'food'),
 ('camomile','camomila','','',4,'food'),
 ('cinnamon','canela','','',4,'food'),
 ('chives','cebolletas','','',4,'food'),
 ('spice','especia','','',4,'food'),
 ('elderberry','saúco','','',4,'food'),
 ('thyme','tomillo','','',4,'food'),
 ('Quince','Membrillo','','',5,'food'),
 ('radish','rábano','','',5,'food'),
 ('fennel','hinojo','','',5,'food'),
 ('hyssop','hisopo','','',5,'food'),
 ('ginseng','ginseng','','',5,'food'),
 ('bay','laurel','','',5,'food'),
 ('sage','salvia','','',5,'food'),
 ('basil','albahaca','','',5,'food'),
 ('chicory','achicoria','endivia','',5,'food'),
 ('yarrow','aquilea','','',5,'food'),
 ('cumin','comino','','',5,'food'),
 ('turmeric','cúrcuma','','',5,'food'),
 ('dandelion','diente de león','','',5,'food'),
 ('juniper','enebro','','',5,'food'),
 ('dill','eneldo','','',5,'food'),
 ('tarragon','estragón','','',5,'food'),
 ('marjoram','mejorana','','',5,'food'),
 ('nettle','ortiga','','',5,'food'),
 ('chervil','perifollo','','',5,'food'),
 ('badminton','badminton','bádminton','',1,'sport'),
 ('basketball','baloncesto','','',1,'sport'),
 ('golf','golf','','',1,'sport'),
 ('hockey','hockey','','',1,'sport'),
 ('judo','judo','','',1,'sport'),
 ('karate','karate','','',1,'sport'),
 ('rugby','rugby','','',1,'sport'),
 ('ski','esquí','','',1,'sport'),
 ('skiing','esquí','','',1,'sport'),
 ('squash','squash','','',1,'sport'),
 ('yoga','yoga','','',1,'sport'),
 ('football','fútbol','','',1,'sport'),
 ('game','juego','','',1,'sport'),
 ('competition','competición','','',1,'sport'),
 ('win','victoria','','',1,'sport'),
 ('loss','derrota','','',1,'sport'),
 ('victory','victoria','','',1,'sport'),
 ('defeat','derrota','','',1,'sport'),
 ('bicycle','bicicleta','','',1,'sport'),
 ('boxing','boxeo','','',1,'sport'),
 ('cycling','ciclismo','','',1,'sport'),
 ('gymnastics','gimnasia','','',1,'sport'),
 ('ice hockey','hockey sobre hielo','','',1,'sport'),
 ('jogging','hacer jogging','jogging','correr',1,'sport'),
 ('kick boxing','kick boxing','','',1,'sport'),
 ('neoprene','neopreno','','',1,'sport'),
 ('Run','Correr','','',1,'sport'),
 ('running','correr','','',1,'sport'),
 ('surfing','surf','','',1,'sport'),
 ('swimming','natación','','',1,'sport'),
 ('tennis','tenis','','',1,'sport'),
 ('volleyball','voleibol','','',1,'sport'),
 ('water polo','waterpolo','','',1,'sport'),
 ('windsurfing','windsurf','','',1,'sport'),
 ('ball','pelota','','',1,'sport'),
 ('football boots','botas de fútbol','','',1,'sport'),
 ('marathon','maratón','','',1,'sport'),
 ('to play','jugar','','',1,'sport'),
 ('to win','ganar','','',1,'sport'),
 ('to lose','perder','','',1,'sport'),
 ('match','partido','','',1,'sport'),
 ('league table','clasificación','','',1,'sport'),
 ('loser','perdedor/a','','',1,'sport'),
 ('spectator','espectador/a','','',1,'sport'),
 ('draw','empate','','',1,'sport'),
 ('Olympic Games','Juegos Olímpicos','','',1,'sport'),
 ('to ride a bicycle','montar en bicicleta','','',1,'sport'),
 ('boots','botas','','',2,'sport'),
 ('darts','dardos','','',2,'sport'),
 ('ice skating','patinaje sobre hielo','','',2,'sport'),
 ('motor racing','carreras de coches','','',2,'sport'),
 ('mountain climbing','alpinismo','escalar montañas','',2,'sport'),
 ('sailing','vela','navegar','',2,'sport'),
 ('socks','calcetines','','',2,'sport'),
 ('sport shoes','zapatillas','zapatillas de deporte','',2,'sport'),
 ('surfboard','tabla de surf','','',2,'sport'),
 ('Walk','Andar','Caminar','Marchar',2,'sport'),
 ('walking','caminar','','',2,'sport'),
 ('to draw','empatar','','',2,'sport'),
 ('to watch','ver','','',2,'sport'),
 ('score','marcador','','',2,'sport'),
 ('winner','ganador/a','','',2,'sport'),
 ('to play away','jugar fuera','','',2,'sport'),
 ('to play at home','jugar en casa','','',2,'sport'),
 ('chain','cadena','','',2,'sport'),
 ('gears','marchas','','',2,'sport'),
 ('baseball','béisbol','','',2,'sport'),
 ('beach volleyball','voley playa','','',2,'sport'),
 ('cricket','críquet','','',2,'sport'),
 ('water skiing','esquí acuático','','',2,'sport'),
 ('wrestling','wrestling','lucha','lucha libre',2,'sport'),
 ('fishing rod','caña de pescar','','',2,'sport'),
 ('hammer throw','lanzamiento de martillo','','',2,'sport'),
 ('high jump','salto de altura','','',2,'sport'),
 ('result','resultado','','',2,'sport'),
 ('opponent','oponente','','',2,'sport'),
 ('canoeing','piragüismo','','',3,'sport'),
 ('climbing','escalada','escalar','',3,'sport'),
 ('fishing','pesca','','',3,'sport'),
 ('hunting','caza','','',3,'sport'),
 ('martial arts','artes marciales','','',3,'sport'),
 ('pool','billar','','',3,'sport'),
 ('shooting','tiro','','',3,'sport'),
 ('snowboarding','snowboard','','',3,'sport'),
 ('badminton racquet','raqueta de bádminton','','',3,'sport'),
 ('baseball bat','bate de béisbol','','',3,'sport'),
 ('boxing glove','guante de boxeo','','',3,'sport'),
 ('squash racquet','raqueta de squash','','',3,'sport'),
 ('tennis racquet','raqueta de tenis','','',3,'sport'),
 ('discus throw','lanzamiento de disco','','',3,'sport'),
 ('triple jump','triple salto','','',3,'sport'),
 ('pedal','pedal','','',3,'sport'),
 ('puncture','pinchazo','','',3,'sport'),
 ('puncture repair kit','juego de herramientas para reparar un pinchazo','','',3,'sport'),
 ('diving','submarinismo','','',3,'sport'),
 ('hiking','hacer senderismo','','',3,'sport'),
 ('horse racing','carrera de caballos','','',3,'sport'),
 ('horse riding','montar a caballo','','',3,'sport'),
 ('inline skating','patinaje en línea','','',3,'sport'),
 ('mountaineering','montañismo','alpinismo','escalar montañas',3,'sport'),
 ('rowing','remo','','',3,'sport'),
 ('running shoes','zapatillas para correr','','',3,'sport'),
 ('skateboard','tabla de skateboard','','',3,'sport'),
 ('skis','esquíes','','',3,'sport'),
 ('bicycle pump','bomba de bicicleta','','',3,'sport'),
 ('tyre','neumático','','',3,'sport'),
 ('go-karting','karting','','',4,'sport'),
 ('heart rate monitor','pulsómetro','monitor de pulso','',4,'sport'),
 ('lacrosse','lacrosse','','',4,'sport'),
 ('skateboarding','skateboard','','',4,'sport'),
 ('skating','patinaje','','',4,'sport'),
 ('hockey stick','stick de hockey','','',4,'sport'),
 ('ice skates','patines de hielo','','',4,'sport'),
 ('pool cue','taco de billar','','',4,'sport'),
 ('rugby ball','pelota de rugby','','',4,'sport'),
 ('fixture','encuentro','','',4,'sport'),
 ('to have a puncture','sufrir un pinchazo','','',4,'sport'),
 ('raincoat','chubasquero','','',4,'sport'),
 ('table tennis','tenis de mesa','','',4,'sport'),
 ('track and field','atletismo','','',4,'sport'),
 ('weightlifting','halterofilia','','',4,'sport'),
 ('golf club','club de golf','palo de golf','',4,'sport'),
 ('referee','árbitro','','',4,'sport'),
 ('brake','freno','','',4,'sport'),
 ('inner tube','cámara de la rueda','','',4,'sport'),
 ('scuba diving','buceo','','',5,'sport'),
 ('snooker','snooker','','',5,'sport'),
 ('syncronized swimming','natación sincronizada','','',5,'sport'),
 ('ten-pin bowling','bolos','','',5,'sport'),
 ('javelin throw','lanzamiento de jabalina','','',5,'sport'),
 ('long jump','salto de longitud','','',5,'sport'),
 ('pole vault','salto de pértiga','','',5,'sport'),
 ('shot put','lanzamiento de peso','','',5,'sport'),
 ('umpire','árbitro','juez de silla','réferi',5,'sport'),
 ('handlebars','manillar','','',5,'sport'),
 ('wheel','rueda','','',5,'sport'),
 ('archery','tiro con arco','','',5,'sport'),
 ('bowls','bolos','','',5,'sport'),
 ('hurdles','vallas','','',5,'sport'),
 ('cricket bat','bate de críquet','','',5,'sport'),
 ('saddle','sillín','','',5,'sport'),
 ('spokes','radios','','',5,'sport'),
 ('sorrel','acedera','','',5,'sport'),
 ('horsetail','cola de caballo','','',5,'sport');
 DROP TABLE IF EXISTS "POLISH";
CREATE TABLE "POLISH" (
	`WORD`	TEXT NOT NULL,
	`TL1`	TEXT NOT NULL,
	`TL2`	TEXT,
	`TL3`	TEXT,
	`NIVEL`	INTEGER NOT NULL,
	`TIPO`	TEXT NOT NULL
);
INSERT INTO `POLISH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('anchovies','anszua','','',1,'FOOD'),
 ('caviar','kawior','','',1,'FOOD'),
 ('crayfish','langusta','','',1,'FOOD'),
 ('homar','homar','','',1,'FOOD'),
 ('octopus','ośmiornica','','',1,'FOOD'),
 ('squid','kałamarnica','','',1,'FOOD'),
 ('amino acid','aminokwas','','',1,'FOOD'),
 ('carbohydrates','węglowodany','','',1,'FOOD'),
 ('vitamins','witaminy','','',1,'FOOD'),
 ('calorie','kaloria','','',1,'FOOD'),
 ('cholesterol','cholesterol','','',1,'FOOD'),
 ('powdered milk','mleko w proszku','','',1,'FOOD'),
 ('almond','migdał','','',1,'FOOD'),
 ('brazil nut','orzech brazylijski','','',1,'FOOD'),
 ('cashew','orzech nerkowca','','',1,'FOOD'),
 ('raisin','rodzynka','','',1,'FOOD'),
 ('coconut','kokos','orzech kokosowy','',2,'FOOD'),
 ('ammonia','amoniak','','',1,'FOOD'),
 ('baking powder','proszek do pieczenia','','',1,'FOOD'),
 ('yeast','drożdże','','',1,'FOOD'),
 ('breadcrumbs','bułka tarta','','',1,'FOOD'),
 ('icing sugar','cukier puder','','',1,'FOOD'),
 ('aniseed','anyż','anyżek','',1,'FOOD'),
 ('basil','bazylia','','',1,'FOOD'),
 ('chamomile','rumianek','rumiankowy','',2,'FOOD'),
 ('chive','szczypiorek','','',1,'FOOD'),
 ('coriander','kolendra','','',1,'FOOD'),
 ('cress','rzeżucha','','',1,'FOOD'),
 ('dill','koper','koperek','',2,'FOOD'),
 ('appetite','apetyt','łaknienie','',1,'FOOD'),
 ('appetizing','apetyczny','smakowity','smaczny',1,'FOOD'),
 ('aroma','zapach','aromat','aromatyczny',3,'FOOD'),
 ('aromatic','aromatyczny','','',1,'FOOD'),
 ('aspic','galareta','','',1,'FOOD'),
 ('bag lunch','drugie śniadanie','kanapki','lunch na wynos',3,'FOOD'),
 ('box lunch','lunch w pudełku','drugie śniadanie','lunch na wynos',3,'FOOD'),
 ('packed lunch','zapakowany lunch','drugie śniadanie','lunch na wynos',3,'FOOD'),
 ('bite','gryźć','','',1,'FOOD'),
 ('bon apetit','smacznego','','',1,'FOOD'),
 ('bone','kość','obierać mięso z kości','',2,'FOOD'),
 ('bone','ość','obierać rybę z ości','',2,'FOOD'),
 ('breaded','panierowany','','',1,'FOOD'),
 ('caffeine','kofeina','','',1,'FOOD'),
 ('creamy','kremowy','gęsty','śmietankowy',3,'FOOD'),
 ('crisps','czipsy','chipsy','',1,'fOOD'),
 ('crispy','kruche','chrupiące','',2,'fOOD'),
 ('delicious','pyszne','','',1,'FOOD'),
 ('dressing','sos sałatkowy','','',1,'FOOD'),
 ('yummy','pyszne','','',1,'FOOD'),
 ('yucky','wstretne','paskudne','okropne',3,'FOOD'),
 ('apricot','morela','','',1,'FOOD'),
 ('blackcurrant','czarna porzeczka','','',1,'FOOD'),
 ('artichoke','karczoch','','',1,'FOOD'),
 ('asparagus','szparagi','','',1,'FOOD'),
 ('baked beans','fasolka w sosie pomidorowym','fasolka po bretońsku','',2,'FOOD'),
 ('baked potato','ziemniak w mundurku','pieczony ziemniak','',2,'FOOD'),
 ('jacket potato','ziemniak w mundurku','pieczony ziemniak','',2,'FOOD'),
 ('green bean','zielona fasolka','fasolka szparagowa','',2,'FOOD'),
 ('soya bean','soja','','',1,'FOOD'),
 ('broad bean','bób','','',2,'FOOD'),
 ('bean sprouts','kiełki fasoli','','',1,'FOOD'),
 ('bagel','bajgiel','obwarzanek','',2,'FOOD'),
 ('bread and butter','chleb z masłem','','',1,'FOOD'),
 ('baker','piekarz','cukiernia','piekarnia',3,'FOOD'),
 ('apron','fartuch','fartuszek','',2,'FOOD'),
 ('banger','kiełbaska','kiełbasa','',2,'FOOD'),
 ('beefburger','kotlet mielony wołowy','','',1,'FOOD'),
 ('starter','przystawka','','',1,'FOOD'),
 ('beverage','napój','','',1,'FOOD'),
 ('bill','rachunek','','',1,'FOOD'),
 ('main course','danie głowne','pierwsze danie','',2,'FOOD'),
 ('soup','zupa','','',1,'FOOD'),
 ('dessert','deser','','',1,'FOOD'),
 ('menu','menu','jadłospis','karta dań',3,'FOOD'),
 ('waiter','kelner','','',1,'FOOD'),
 ('waitress','kelnerka','','',1,'FOOD'),
 ('chef','szef kuchni','','',1,'FOOD'),
 ('cook','kucharz','','',1,'FOOD'),
 ('customer','klient','','',1,'FOOD'),
 ('takeaway','danie na wynos','na wynos','',1,'FOOD'),
 ('order','zamówić','','',1,'FOOD'),
 ('pay by credit card','płacić kartą kredytową','','',1,'FOOD'),
 ('boiling point','temeratura wrzenia','','',1,'FOOD'),
 ('braise','dusić','gotować na wolnym ogniu','',2,'FOOD'),
 ('bottle opener','otwieracz do butelek','','',1,'FOOD'),
 ('can opener','otwieracz do konserw','','',1,'FOOD'),
 ('tin opener','otwieracz do konserw','','',1,'FOOD'),
 ('chopsticks','pałeczki','','',1,'FOOD'),
 ('corkscrew','korkociag','','',1,'FOOD'),
 ('crockery','naczynia','porcelana','zastawa stołowa',3,'FOOD'),
 ('bouillon','bulion','rosół','',2,'FOOD'),
 ('broth','gęsta zupa','','',2,'FOOD'),
 ('breakfast','śniadanie','','',1,'FOOD'),
 ('lunch','drugie śniadanie','lunch','obiad',3,'FOOD'),
 ('brunch','połączenie śniadania z lunchem','','',1,'FOOD'),
 ('dinner','obiad','kolacja','',2,'FOOD'),
 ('tea','podwieczorek','herbatka','',2,'FOOD'),
 ('supper','kolacja','','',1,'FOOD'),
 ('buffet','bufet','','',1,'FOOD'),
 ('restaurant','restauracja','','',1,'FOOD'),
 ('cafe','kawiarnia','herbaciarnia','',2,'FOOD'),
 ('canteen','kantyna','stołówka','',2,'FOOD'),
 ('diner','stołówka','jadłodalnia','',2,'FOOD'),
 ('buffet car','wagon restauracyjny','','',1,'FOOD'),
 ('butcher','rzeźnik','sklep mięsny','',2,'FOOD'),
 ('cafeteria','stołówka','bufet','kantyna',3,'FOOD'),
 ('coffee bar/shop','bar kawowy','','',1,'FOOD'),
 ('delicatessen','delikatesy','','',1,'FOOD'),
 ('can','puszka','','',1,'FOOD'),
 ('tin','konserwa','','',1,'FOOD'),
 ('carafe','karafka','','',1,'FOOD'),
 ('carton','karton','','',1,'FOOD'),
 ('abseil','spuszczać się na linie','','',2,'SPORT'),
 ('attack','atakować','','',1,'SPORT'),
 ('award','nagradzać','przyznawać nagrodę','',2,'SPORT'),
 ('backpack','uprawiać turystykę pieszą','','',1,'SPORT'),
 ('back-pedal','pedałować do tyłu','','',1,'SPORT'),
 ('beat','pokonać','','',1,'SPORT'),
 ('canoe','pływać kajakiem','','',1,'SPORT'),
 ('climb','wspinać się','','',1,'SPORT'),
 ('compete','współzawodniczyć','rywalizować','konkurować',3,'SPORT'),
 ('cycle','jechać na rowerze','','',1,'SPORT'),
 ('defend','bronić','','',1,'SPORT'),
 ('do aerobics','ćwiczyć aerobik','','',1,'SPORT'),
 ('dribble','kozłować','odbijać','',2,'SPORT'),
 ('exercise','ćwiczyc','gimnastykować się','',2,'SPORT'),
 ('go by bike','jechać rowerem','','',1,'SPORT'),
 ('go jogging','iść pobiegac','','',1,'SPORT'),
 ('go swimming','iść popływać','','',1,'SPORT'),
 ('jog','biegac','','',1,'SPORT'),
 ('jump','skakać','','',1,'SPORT'),
 ('kick','kopać','','',1,'SPORT'),
 ('pass','podać','podawać','',2,'SPORT'),
 ('play baseball','grac w baseball','','',1,'SPORT'),
 ('play basketball','grać w koszykówkę','','',1,'SPORT'),
 ('play chess','grać w szachy','','',1,'SPORT'),
 ('play football','grać w piłkę nożną','','',1,'SPORT'),
 ('play handball','grać w piłkę ręczną','','',1,'SPORT'),
 ('play hockey','grać w hokeja','','',1,'SPORT'),
 ('play rugby','grać w rugby','','',1,'SPORT'),
 ('play volleyball','grać w siatkówkę','','',1,'SPORT'),
 ('ride a bike','jeździć na rowerze','','',1,'SPORT'),
 ('row','wiosłować','','',1,'SPORT'),
 ('run','biegać','','',1,'SPORT'),
 ('tackle','kiwać','blokować','chwytać',1,'SPORT'),
 ('walk','iść','spacerować','',2,'SPORT'),
 ('abseiling','spuszczanie się na linie','','',1,'SPORT'),
 ('acrobatics','akrobatyka','','',1,'SPORT'),
 ('aerobics','aerobik','','',1,'SPORT'),
 ('American footbal','footbal amerykański','','',1,'SPORT'),
 ('archery','łucznictwo','','',1,'SPORT'),
 ('athletics','lekkoatletyka','','',1,'SPORT'),
 ('backpacking','turystyka piesza z plecakiem','','',1,'SPORT'),
 ('backstroke','styl grzbietowy','pływać grzbietem','',2,'SPORT'),
 ('badminton','badminton','kometka','',2,'SPORT'),
 ('basketball','koszykówka','','',1,'SPORT'),
 ('baseball','baseball','','',1,'SPORT'),
 ('board game','gra planszowa','','',1,'SPORT'),
 ('bodybuilding','kulturystyka','','',1,'SPORT'),
 ('bowling','gra w kręgle','','',1,'SPORT'),
 ('boxing','boks','','',1,'SPORT'),
 ('breaststroke','styl klasyczny','żabka','',2,'SPORT'),
 ('butterfly','styl motylkowy','','',1,'SPORT'),
 ('canoeing','kajakarstwo','pływanie kajakiem','',2,'SPORT'),
 ('checkers','warcaby','','',1,'SPORT'),
 ('crawl','kraul','pływanie kraulem','',2,'SPORT'),
 ('cricket','krykiet','','',1,'SPORT'),
 ('cycling','kolarstwo','','',1,'SPORT'),
 ('draughts','warcaby','','',1,'SPORT'),
 ('fencing','szermierka','fechtunek','',2,'SPORT'),
 ('field tennis','tenis','','',1,'SPORT'),
 ('football','piłka nożna','','',1,'SPORT'),
 ('golf','golf','','',1,'SPORT'),
 ('gymnastics','gimnastyka','','',1,'SPORT'),
 ('handball','piłka ręczna','','',1,'SPORT'),
 ('hockey','hokej','','',1,'SPORT'),
 ('horse racing','wyścigi konne','','',1,'SPORT'),
 ('judo','dżudo','','',1,'SPORT'),
 ('kayaking','kajakarstwo','pływanie kajakiem','',2,'SPORT'),
 ('lacrosse','lakros','','',1,'SPORT'),
 ('marathon','maraton','','',1,'SPORT'),
 ('parachuting','skoki spadochronowe','','',1,'SPORT'),
 ('polo','polo','','',1,'SPORT'),
 ('rowing','wioślarstwo','','',1,'SPORT'),
 ('rugby','rugby','','',1,'SPORT'),
 ('sailing','żeglarstwo','','',1,'SPORT'),
 ('skateboarding','jazda na deskorolce','','',1,'SPORT'),
 ('skating','łyżwiarstwo','','',1,'SPORT'),
 ('skiiing','narciarstwo','','',1,'SPORT'),
 ('skydiving','skoki spadochronowe','','',1,'SPORT'),
 ('snowboarding','snowboarding','','',1,'SPORT'),
 ('sprint','sprint','','',1,'SPORT'),
 ('surfing','pływanie na desce surfingowej','','',1,'SPORT'),
 ('swimming','pływanie','','',1,'SPORT'),
 ('table tennis','tenis stołowy','','',1,'SPORT'),
 ('triathlon','triatlon','','',1,'SPORT'),
 ('valleyball','siatkówka','piłka siatkowa','',2,'SPORT'),
 ('weightlifting','podnoszenie ciężarów','','',1,'SPORT'),
 ('wingsuit','latanie w kombinezonie','','',1,'SPORT'),
 ('white-water rafting','spływ górski','','',1,'SPORT'),
 ('workout','trening','zaprawa fizyczna','',2,'SPORT'),
 ('yoga','joga','','',1,'SPORT'),
 ('backpack','plecak do wędrówek','','',1,'SPORT'),
 ('ballpark','boisko baseballowe','','',1,'SPORT'),
 ('baseball','piłka koszykowa','piłka do koszykówki','',2,'SPORT'),
 ('baseball bat','kij baseballowy','','',1,'SPORT'),
 ('baseball glove','rękawica baseballowa','','',1,'SPORT'),
 ('basket','kosz','','',1,'SPORT'),
 ('basketball','piłka baseballowa','piłka do baseballu','',2,'SPORT'),
 ('bat','rakietka do tenisa stołowego','kij baseballowy','kij do krykieta',3,'SPORT'),
 ('bicycle','rower','','',1,'SPORT'),
 ('bike','rower','motocykl','',2,'SPORT'),
 ('bobsleigh','bobslej','sanki','',2,'SPORT'),
 ('bow','łuk','','',1,'SPORT'),
 ('boxing gloves','rękawice bokserskie','','',1,'SPORT'),
 ('canoe','kajak','','',1,'SPORT'),
 ('exercise bike','rower treningowy','','',1,'SPORT'),
 ('foil','floret','','',1,'SPORT'),
 ('football','piłka nożna','piłka do footballu','',2,'SPORT'),
 ('golf club','kij golfowy','','',1,'SPORT'),
 ('handball','piłka do ręcznej','','',1,'SPORT'),
 ('helmet','kask','','',1,'SPORT'),
 ('hockey puck','krążek do hokeja','krążek hokejowy','',2,'SPORT'),
 ('hockey stick','kij hokejowy','','',1,'SPORT'),
 ('horse','koń','','',1,'SPORT'),
 ('jockey cap','toczek do jazdy konnej','','',1,'SPORT'),
 ('jump','przeszkoda','','',1,'SPORT'),
 ('kayak','kajak','','',1,'SPORT'),
 ('mask','maska','','',1,'SPORT'),
 ('net','siatka','','',1,'SPORT'),
 ('paddle','wiosło','','',1,'SPORT'),
 ('parachute','spadochron','','',1,'SPORT'),
 ('quanco','piłka do rugby','','',1,'SPORT'),
 ('racket','rakieta','','',1,'SPORT'),
 ('saddle','siodło','','',1,'SPORT'),
 ('sail','żagiel','','',1,'SPORT'),
 ('sailboat','żaglówka','','',1,'SPORT'),
 ('shuttlecock','lotka do badmintona','','',1,'SPORT'),
 ('skateboard','deskorolka','','',1,'SPORT'),
 ('skates','łyżwy','','',1,'SPORT'),
 ('skis','narty','','',1,'SPORT'),
 ('ski poles','kijki narciarskie','','',1,'SPORT'),
 ('snowboard','deska do snowboardu','','',1,'SPORT'),
 ('surfboard','deska surfingowa','','',1,'SPORT'),
 ('swimsuit','kostium pływacki','','',1,'SPORT'),
 ('swimming cap','czepek pływacki','','',1,'SPORT'),
 ('swimming trunks','kąpielówki','','',1,'SPORT'),
 ('target','cel','tarcza','',2,'SPORT'),
 ('tracksuit','dres','','',1,'SPORT'),
 ('trainers','butry sportowe','adidasy','',1,'SPORT'),
 ('weight','ciężar','ciężarek','',2,'SPORT'),
 ('wingsuit','kombinezon do latania','','',1,'SPORT'),
 ('yacht','jacht','','',1,'SPORT'),
 ('acrobat','akrobata','akrobatka','',1,'SPORT'),
 ('adversary','przeciwnik','przeciwniczka','rywal',1,'SPORT'),
 ('arbiter','arbiter','','',1,'SPORT'),
 ('archer','łucznik','łuczniczka','',1,'SPORT'),
 ('athlete','lekkoatleta','sportowiec','',2,'SPORT'),
 ('attacker','napastnik','','',1,'SPORT'),
 ('backpacker','turysta uprawiający wędrówkę pieszą','','',1,'SPORT'),
 ('baseplayer','biegacz','','',1,'SPORT'),
 ('biker','rowerzysta','cyklista','motocyklista',3,'SPORT'),
 ('bodybuilder','kulturysta','kulturystka','',1,'SPORT'),
 ('boxer','bokser','','',1,'SPORT'),
 ('catcher','łapacz','','',1,'SPORT'),
 ('champion','mistrz','mistrzyni','czempion',3,'SPORT'),
 ('coach','trener','','',1,'SPORT'),
 ('commenter','komentator','','',1,'SPORT'),
 ('competitor','zawodnik','przeciwnik','współzawodnik',3,'SPORT'),
 ('contestant','zawodnik','','',1,'SPORT'),
 ('cricketer','gracz w krykieta','','',1,'SPORT'),
 ('cyclist','rowerzysta','cyklista','',2,'SPORT'),
 ('defender','obrońca','','',1,'SPORT'),
 ('fan','kibic','fan','',2,'SPORT'),
 ('fencer','szermierz','','',1,'SPORT'),
 ('goalkeeper','bramkarz','','',1,'SPORT'),
 ('gymnast','gimnastyk','','',1,'SPORT'),
 ('jockey','dżokej','','',1,'SPORT'),
 ('parachuter','spadochroniarz','','',1,'SPORT'),
 ('pitcher','zawodnik rzucający piłką','miotacz','',2,'SPORT'),
 ('player','gracz','zawodnik','uczestnik',3,'SPORT'),
 ('refree','sędzia','','',1,'SPORT'),
 ('runner','biegacz','','',1,'SPORT'),
 ('skater','łyżwiarz','','',1,'SPORT'),
 ('skiier','narciarz','','',1,'SPORT'),
 ('ski jumper','skoczek narciarski','','',1,'SPORT'),
 ('sprinter','sprinter','','',1,'SPORT'),
 ('supporter','kibic','pomocnik','',2,'SPORT'),
 ('surfer','serfer','','',1,'SPORT'),
 ('umpire','sędzia','','',1,'SPORT'),
 ('winner','zwycięzca','','',1,'SPORT'),
 ('able-bodied','zdrowy fizycznie','pełnosprawny','',2,'SPORT'),
 ('ace','as','as serwisowy','',2,'SPORT'),
 ('acrobatic','akrobatyczny','','',1,'SPORT'),
 ('adrenalin','adrenalina','','',1,'SPORT'),
 ('alpine','alpejski','wysokogórski','',2,'SPORT'),
 ('amateur','amator','amatorka','',1,'SPORT'),
 ('ascent','wspinaczka','','',1,'SPORT'),
 ('athletic','wysportowany','lekkoatletyczny','spotowy',3,'SPORT'),
 ('attack','atak','','',1,'SPORT'),
 ('audience','publiczność','widownia','',2,'SPORT'),
 ('award','nagroda','','',1,'SPORT'),
 ('backhand','bekhend','','',1,'SPORT'),
 ('biceps','biceps','','',1,'SPORT'),
 ('bikini','dwuczęściowy kostium kąpielowy','bikini','',2,'SPORT'),
 ('bronze medal','brązowy medal','','',1,'SPORT'),
 ('championship','mistrzostwo','','',1,'SPORT'),
 ('checkmate','szach mat','','',1,'SPORT'),
 ('competition','rywalizacja','konkurencja','konkurs',3,'SPORT'),
 ('competitive','konkurencyjny','','',1,'SPORT'),
 ('contest','zawody','konkurs','',2,'SPORT'),
 ('tournament','zawody sportowe','rozgrywki sportowe','',2,'SPORT'),
 ('defence','obrona','','',1,'SPORT'),
 ('disabled','niepełnosprawny','','',1,'SPORT'),
 ('fit','sprawny','','',1,'SPORT'),
 ('physical activity','aktywność fizyczna','','',1,'SPORT'),
 ('stadium','stadion','','',1,'SPORT'),
 ('cross country','przełajowy (bieg)','','',1,'SPORT'),
 ('downhill','zjazdowe (narciarstwo)','','',1,'SPORT');
 DROP TABLE IF EXISTS "GERMAN";
CREATE TABLE "GERMAN" (
	`WORD`	TEXT NOT NULL,
	`TL1`	TEXT NOT NULL,
	`TL2`	TEXT,
	`TL3`	TEXT,
	`NIVEL`	INTEGER NOT NULL,
	`TIPO`	TEXT NOT NULL
);
INSERT INTO `GERMAN` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('to serve','aufschlagen','bedienen','',2,'sport'),
 ('net','Netz','','',1,'sport'),
 ('to jump','springen','','',1,'sport'),
 ('to block','blocken','verteidigen','',1,'sport'),
 ('ace','Ass','mit dem Aufschlag punkten','',3,'sport'),
 ('to trap','annehmen','','',4,'sport'),
 ('to assist','auflegen','stellen','helfen',2,'sport'),
 ('to attack','angreifen','attackieren','',1,'sport'),
 ('to score','punkten','treffen','',2,'sport'),
 ('defense','Verteidigung','Abwehr','',2,'sport'),
 ('pass','Zuspiel','Pass','',1,'sport'),
 ('server','Aufschläger','Angabenmacher','',3,'sport'),
 ('substitute','Auswechselspieler','Ersatzspieler','',3,'sport'),
 ('court','Spielfeld','','',3,'sport'),
 ('to spike','schmettern','schlagen','',3,'sport'),
 ('spiker','Angreifer','Offensivspieler','',4,'sport'),
 ('to set','pritschen','auflegen','stellen',2,'sport'),
 ('to bump','baggern','','',3,'sport'),
 ('foul/ fault','Foul','Fehler','Vergehen',1,'sport'),
 ('set','Satz','','',2,'sport'),
 ('service','Aufschlag','','',3,'sport'),
 ('line','Linie','','',1,'sport'),
 ('audience','Zuschauer','','',3,'sport'),
 ('jersey','Trikot','','',4,'sport'),
 ('volleyball','Volleyball','','',1,'sport'),
 ('climb','klettern','','',1,'sport'),
 ('(to) secure','sichern','','',2,'sport'),
 ('rope','Seil','','',3,'sport'),
 ('(to) boulder','bouldern','','',4,'sport'),
 ('strap/belt','Gürtel','','',5,'sport'),
 ('coach','Trainer','','',1,'sport'),
 ('fun','Freude','Spaß','',2,'sport'),
 ('friends','Freunde','','',1,'sport'),
 ('climbing clutches','Klettergriffe','','',3,'sport'),
 ('climbing shoes','Kletterschuhe','','',2,'sport'),
 ('sportswear','Sportkleidung','','',1,'sport'),
 ('knot','Schlaufe','Knoten','',5,'sport'),
 ('hook','Karabiner','','',5,'sport'),
 ('climbing hall','Kletterhalle','','',3,'sport'),
 ('climbing church','Kletterkirche','','',5,'sport'),
 ('protection device','Sicherungsgerät','','',4,'sport'),
 ('nut (climbing)','Klemmkeil','','',4,'sport'),
 ('climbing helmet','Kletterhelm','','',3,'sport'),
 ('gloves','Handschuhe','','',4,'sport'),
 ('alpin climbing','Alpinklettern','','',3,'sport'),
 ('sport climbing','Sportklettern','','',2,'sport'),
 ('fear','Angst','','',1,'sport'),
 ('big wall','große Wand','hohe Wand','',4,'sport'),
 ('loop','Schleife','Schlinge','Schlaufe',5,'sport'),
 ('height','Höhe','','',2,'sport'),
 ('lettuce','Salat','Salatkopf','',2,'food'),
 ('vegetables','Gemüse','','',2,'food'),
 ('dressing','Dressing','Salatsoße','Salatsauce',1,'food'),
 ('cucumber','Gurke','','',3,'food'),
 ('tomato','Tomate','','',1,'food'),
 ('onion','Zwiebel','Lauch','',4,'food'),
 ('to cube','würfeln','in Würfel schneide','',5,'food'),
 ('corn','Mais','','',2,'food'),
 ('pepper','Paprika','Pfeffer','',3,'food'),
 ('olive oil','Olivenöl','','',1,'food'),
 ('vinegar','Essig','','',4,'food'),
 ('herbs','Kräuter','','',4,'food'),
 ('to chop','hacken','','',5,'food'),
 ('to roast','braten','','',4,'food'),
 ('to steam','dünsten','','',5,'food'),
 ('eggplant','Aubergine','','',5,'food'),
 ('garlic','Knoblauch','','',2,'food'),
 ('pumpkin','Kürbis','','',3,'food'),
 ('potato','Kartoffel','Erdapfel','',2,'food'),
 ('cauliflower','Blumenkohl','','',4,'food'),
 ('cabbage','Kohl','','',3,'food'),
 ('broccoli','Brokkoli','','',1,'food'),
 ('mushrooms','Pilze','','',3,'food'),
 ('peas','Erbsen','','',1,'food'),
 ('asparagus','Spargel','','',5,'food'),
 ('bacon','Speck','','',3,'food'),
 ('beef','Rindfleisch','','',2,'food'),
 ('chicken','Huhn','','',1,'food'),
 ('duck','Ente','','',2,'food'),
 ('ham','Schinken','','',3,'food'),
 ('lamb','Lamm','','',2,'food'),
 ('lean meat','mageres Fleisch','','',4,'food'),
 ('minced meat','Hackfleisch','','',5,'food'),
 ('pork','Schweinefleisch','','',2,'food'),
 ('salami','Salami','','',1,'food'),
 ('sausage','Wurst','Würstchen','',3,'food'),
 ('poultry','Geflügel','','',5,'food'),
 ('meat','Fleisch','','',1,'food'),
 ('turkey','Truthahn','','',4,'food'),
 ('cutlet','Kotelett','','',4,'food'),
 ('veal','Kalbfleisch','','',5,'food'),
 ('to spice','würzen','','',3,'food'),
 ('chicken leg','Hähnchenkeule','','',4,'food'),
 ('to fry','frittieren','','',3,'food'),
 ('white meat','weißes Fleisch','','',2,'food'),
 ('steak','Steak','','',1,'food'),
 ('boned meat','Fleisch ohne Knochen','','',5,'food'),
 ('roast','braten','Braten','',4,'food'),
 ('marinade','Marinade','','',1,'food'),
 ('fork','Gabel','','',1,'food'),
 ('knife','Messer','','',1,'food'),
 ('spoon','Löffel','','',1,'food'),
 ('cup','Tasse','','',1,'food'),
 ('plate','Teller','','',1,'food'),
 ('pan','Pfanne','','',2,'food'),
 ('sink','Spüle','Waschbecken','Spülbecken',2,'food'),
 ('oven','Ofen','','',2,'food'),
 ('stove','Herd','','',2,'food'),
 ('refrigerator','Kühlschrank','','',2,'food'),
 ('whisk','Schneebesen','','',3,'food'),
 ('to do the dishes','Den Abwasch machen','abwaschen','',3,'food'),
 ('grater','Reibe','Raspel','',3,'food'),
 ('rolling pin','Nudelholz','','',3,'food'),
 ('tin opener','Dosenöffner','','',3,'food'),
 ('ladle','Kelle','Schöpfkelle','Suppenkelle',4,'food'),
 ('corkscrew','Korkenzieher','','',4,'food'),
 ('saucepan','Kochtopf','','',4,'food'),
 ('oven cloth','Topflappen','','',4,'food'),
 ('strainer','Sieb','','',4,'food'),
 ('draining board','Abtropfbrett','','',5,'food'),
 ('extractor hood','Dunstabzugshaube','Abzugshaube','',5,'food'),
 ('grinder','Fleischwolf','','',5,'food'),
 ('springform pan','Springform','Kuchenform','',5,'food'),
 ('pressure cooker','Schnellkochtopf','Dampfkochtop','Damfdruckkochtopf',5,'food'),
 ('run','laufen','rennen','',1,'sport'),
 ('proteins','Proteine','Eiweiße','',1,'food'),
 ('calories','Kalorien','','',1,'food'),
 ('vitamins','Vitamine','','',1,'food'),
 ('vegan','vegan','','',1,'food'),
 ('low calorie','kalorienarm','wenig Kalorien','',1,'food'),
 ('tp lose weight','abnehmen','Gewicht verlieren','',2,'food'),
 ('vegetarian dishes','vegetarische Gerichte','','',2,'food'),
 ('clean eating','sauberes Essen','gesundes Essen','',2,'food'),
 ('low fat','niedriger Fettgehalt','','',2,'food'),
 ('health','Gesundheit','','',2,'food'),
 ('recipe ideas','Rezeptideen','','',3,'food'),
 ('fatburner','Fettverbrenner','','',3,'food'),
 ('nutritional change','Ernährungsumstellung','','',3,'food'),
 ('balanced diet','ausgewogene Diät','ausgewogene Ernährung','',3,'food'),
 ('to go shopping','einkaufen','einkaufen gehen','',3,'food'),
 ('gluten free','glutenfrei','','',4,'food'),
 ('fiber','Ballaststoffe','','',4,'food'),
 ('low carb','wenig Kohlenhydrate','','',4,'food'),
 ('green smoothie','grüner Smoothie','','',4,'food'),
 ('healthy food','gesundes Essen','gesunde Lebensmittel','',4,'food'),
 ('paleo diet','Paleo Diät','Ernährungsart die sich an der Altsteinzeit orientiert','',5,'food'),
 ('detox cure','Detox Kur','Stoppen von ungesunden Gewohnheiten','',5,'food'),
 ('to be physically fit','körperlich fit sein','','',5,'food'),
 ('chia seeds','Chia Samen','Chiasamen','Chia-Samen',5,'food'),
 ('quinoa','gesunde essbare Pflanzenart','Quinoa','',5,'food'),
 ('to bake','backen','','',1,'food'),
 ('pastry','Mehlspeise','Süßspeise','',1,'food'),
 ('flour','Mehl','','',1,'food'),
 ('sugar','Zucker','','',1,'food'),
 ('cream','Crème','Sahne','',1,'food'),
 ('to combine','kombinieren','','',1,'food'),
 ('ginger bread','Lebkuchen','','',1,'food'),
 ('to preheat','vorheizen','','',2,'food'),
 ('pudding','Pudding','','',1,'food'),
 ('dough','Teig','','',2,'food'),
 ('to knead','kneten','','',2,'food'),
 ('cooling rack','Tortengitter','','',2,'food'),
 ('to beat','schlagen','','',2,'food'),
 ('to caramelize','karamellisieren','','',2,'food'),
 ('baking pan','Backform','','',2,'food'),
 ('vanilla extract','Vanillezucker','','',2,'food'),
 ('granulated sugar','Kristallzucker','','',2,'food'),
 ('whipped cream','Schlagsahne','','',2,'food'),
 ('to whip cream','Sahne schlagen','','',2,'food'),
 ('egg yolk','Eidotter','Eigelb','',2,'food'),
 ('wafer','Oblate','','',3,'food'),
 ('batter','Teig','','',3,'food'),
 ('to whisk','schlagen','rühren','',3,'food'),
 ('custard','Vanillecreme','','',3,'food'),
 ('yeast','Germ','Hefe','',5,'food'),
 ('to sprinkle','bestreuen','streuen','',3,'food'),
 ('to glaze','glasieren','','',4,'food'),
 ('gelatine','Gelatine','','',4,'food'),
 ('parchment paper','Backpapier','','',4,'food'),
 ('puff pastry','Blätterteig','','',4,'food'),
 ('pastry bag','Spritztüte','Spritzbeutel','',5,'food'),
 ('to flambé','flambieren','','',5,'food'),
 ('convection','Umluft','Heißluft','',5,'food'),
 ('to blend','vermischen','','',5,'food'),
 ('ball','Ball','Kugel','',1,'sport'),
 ('pitch','Spielfeld','','',2,'sport'),
 ('team','Mannschaft','Team','',1,'sport'),
 ('playing time','Spielzeit','','',1,'sport'),
 ('pause','Pause','Unterbrechung','',1,'sport'),
 ('referee','Schiedsrichter','','',5,'sport'),
 ('sports discipline','Sportart','','',5,'sport'),
 ('hall','Halle','Sporthalle','',2,'sport'),
 ('tournament','Turnier','','',3,'sport'),
 ('hockey','Hockey','','',1,'sport'),
 ('stick','Schläger','','',2,'sport'),
 ('astroturf','Kunstrasen','','',5,'sport'),
 ('goal','Tor','','',2,'sport'),
 ('halfway line','Mittelline','','',2,'sport'),
 ('to pass','Passen','','',3,'sport'),
 ('mouthguard','Mundschutz','','',3,'sport'),
 ('equipment','Ausrüstung','Ausstattung','',3,'sport'),
 ('protection','Schutz','','',3,'sport'),
 ('bag','Tasche','','',4,'sport'),
 ('shoes','Schuhe','','',4,'sport'),
 ('careful','vorsichtig','umsichtig','achtsam',4,'sport'),
 ('fun','Spaß','Vergnügen','',4,'sport'),
 ('penalty','Strafe','Strafstoß','Elfmeter',5,'sport'),
 ('carbohydrates','Kohlenhydrate','','',4,'food'),
 ('healthy body','gesunder Körper','','',3,'food'),
 ('cardio','Herz','Kardio','',3,'sport'),
 ('to coach','einarbeiten','trainieren','',2,'sport'),
 ('to stretch','dehnen','strecken','',1,'sport'),
 ('muscle','Muskel','','',1,'sport'),
 ('gym','Fitnessstudio','Sporthalle','',1,'sport'),
 ('stamina','Kondition','Ausdauer','',2,'sport'),
 ('power','Kraft','Energie','',2,'sport'),
 ('jumping jack','Hampelmann','','',3,'sport'),
 ('cardiovascular system','Herz-Kreislauf-System','','',5,'sport'),
 ('to maintain weight','das Gewicht halten','Gewicht halten','',5,'food'),
 ('workout','Training','Übungseinheit','',2,'sport'),
 ('coordination','Koordination','','',2,'sport'),
 ('to live healthy','gesung leben','','',3,'sport'),
 ('to warm up','aufwärmen','','',1,'sport'),
 ('rhythm','Rhythmus','','',1,'sport'),
 ('step machine','Stepper','','',3,'sport'),
 ('dumbbell','Hantel','Kurzhantel','',5,'sport'),
 ('crunches','Bauchpressen','','',5,'sport'),
 ('muscle building','Muskelaufbau','','',4,'sport'),
 ('dietary supplement','Nahrungsergänzungsmittel','','',5,'food'),
 ('to digest sth.','etw. verdauen','etwas verdauen','verdauen',4,'food'),
 ('ambition','Ehrgeiz','','',4,'sport'),
 ('emotion','Leidenschaft','','',3,'sport'),
 ('strength','Kraft','','',2,'sport'),
 ('discipline','Disziplin','','',2,'sport'),
 ('boxing ring','Boxring','','',1,'sport'),
 ('rules','Regeln','','',2,'sport'),
 ('to fight','kämpfen','','',3,'sport'),
 ('pain','Schmerzen','Schmerz','',4,'sport'),
 ('to win','gewinnen','','',2,'sport'),
 ('to lose','verlieren','','',3,'sport'),
 ('experience','Erfahrung','','',2,'sport'),
 ('to lern','lernen','','',5,'sport'),
 ('spectator','Zuschauer','','',3,'sport'),
 ('judge','Punkterichter','','',5,'sport'),
 ('defence','Verteidigung','','',5,'sport'),
 ('tradition','Tradition','','',1,'sport'),
 ('dangerous','gefährlich','','',4,'sport'),
 ('to peel','schälen','','',3,'food'),
 ('to rasp','reiben','raspeln','',2,'food'),
 ('to add','hinzufügen','','',1,'food'),
 ('to melt','schmelzen','','',2,'food'),
 ('to wash','waschen','','',1,'food'),
 ('to pour','gießen','','',4,'food'),
 ('to taste','abschmecken','schmecken','probieren',2,'food'),
 ('cheese','Käse','','',1,'food'),
 ('curd','Quark','','',5,'food'),
 ('yoghurt','Joghurt','','',1,'food'),
 ('milk','Milch','','',1,'food'),
 ('parmesan','Parmesan','','',1,'food'),
 ('butter milk','Buttermilch','','',2,'food'),
 ('soft cheese','Weichkäse','','',2,'food'),
 ('milk powder','Milchpulver','','',1,'food'),
 ('milkshake','Milchshake','','',2,'food'),
 ('ice cream','Eiskrem','Eis','Eiscreme',2,'food'),
 ('milk roll','Milchbrötchen','','',3,'food'),
 ('pudding','Pudding','','',1,'food'),
 ('golfbag','Golftasche','','',1,'sport'),
 ('out','aus','Aus','',1,'sport'),
 ('best ball','bester Ball','','',1,'sport'),
 ('clubhouse','Clubhaus','','',1,'sport'),
 ('down','runter','unten','',1,'sport'),
 ('to serve','bedienen','','',2,'sport'),
 ('bag tag','Anhänger','','',2,'sport'),
 ('to swing','schwingen','schlagen','',2,'sport'),
 ('break','Break','brechen','',2,'sport'),
 ('golf club','Golfschläger','','',2,'sport'),
 ('bunker','Sandhindernis','Kasten','',3,'sport'),
 ('golf course','Golfbahn','Golfplatz','',3,'sport'),
 ('driving range','Übungsgelände','Übungsplatz','',3,'sport'),
 ('iron','Eisen','','',3,'sport'),
 ('fee','Gebühr','','',3,'sport'),
 ('chip','kurzer Schlag','','',4,'sport'),
 ('handicap','Spielstärke','Vorgabe','Handicap',4,'sport'),
 ('hole-in-one','Volltreffer','mit einem Schlag einlochen','',4,'sport'),
 ('hazard','Hindernis','','',5,'sport'),
 ('grain','Maserung','Getreide','',5,'sport');
DROP TABLE IF EXISTS "FRENCH";
CREATE TABLE "FRENCH" (
	`WORD`	TEXT NOT NULL,
	`TL1`	TEXT NOT NULL,
	`TL2`	TEXT,
	`TL3`	TEXT,
	`NIVEL`	INTEGER NOT NULL,
	`TIPO`	TEXT NOT NULL
);
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('spoon','cuiller','cuillère','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fork','forchette','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('knife','couteau','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('teaspoon','cuiller à café','cuillère à café','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('laddle','louche','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('measuring cup','gobelet gradué','gobelet doseur','verre gradué',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('measuring jug','bol mesureur','verre gradué','cruche graduée',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sieve','passoire','tamis','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('chopping board','planche à découper','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tray','plateau','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('funnel','entonnoir','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('breadbox','grenier à pain','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('drainer','égouttoir','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('draining board','égouttoir','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('plate','assiette','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bowl','bol','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('saucer','soucoupe','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('platter','plat','plateau','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('glass','verre','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mug','mug','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jug','pot','carafe','cruche',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('teapot','théière','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cup','tasse','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jar','pot','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pot','pot','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('frying pan','poêle à frire','poêle','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('casserole dish','plat à four','cocotte','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('saucepan','casserole','cocotte','poêlon',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baking pan','plat de cuisson','moule','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lid','couvercle','','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('kettle','bouilloire','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('toaster','grille-pain','toaster','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lemon squeezer','presse-citron','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('blender','mixeur','blender','mélangeur',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mixer','mixeur','mélangeur','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('food processor','robot','robot culinaire','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('grater','râpe','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mincer','hachoir','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('juicer','presse-fruits','centrifugeuse','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('coffee maker','cafetière','machine à café','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('microwave oven','four à micro-ondes','micro-ondes','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('oven','four','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('stove','cuisinière','poêle','fourneau',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fridge','frigo','frigidaire','réfrigérateur',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('freezer','congélateur','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('dishwasher','lave-vaisselle','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sink','évier','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cook','cuisiner','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('simmer','mijoter','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fry','frire','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('chop','couper','hacher','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('slice','trancher','couper','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cut','couper','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('peel','éplucher','peler','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mash','écraser','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('stir','remuer','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mix','mélanger','','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('deep fry','frire','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('defrost','décongeler','dégeler','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('heat up','réchauffer','chauffer','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mince','hacher','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('season','assaisonner','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('whisk','battre','fouetter','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('beat','battre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('crush','écraser','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('grind','moudre','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('grate','râper','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('crusty','croustillant','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sizzling','brûlant','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('yoghurt','yaourt','yogourt','yoghourt',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cheese','fromage','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('milk','lait','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('buttermilk','babeurre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('butter','beurre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('margarine','margarine','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cream','crème','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('egg','œuf','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cottage cheese','fromage blanc','cottage cheese','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('blue cheese','fromage bleu','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('brie','brie','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('goat cheese','fromage de chèvre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skimmed milk','lait écrémé','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('semi-skimmed milk','lait demi-écrémé','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('whey','petit-lait','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ice cream','glace','crème glacée','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lactose','lactose','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('yolk','jaune d''œuf','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('white','blanc d''œuf','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cultured milk','lait de culture','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('curds','caillebotte','lait caillé','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('condensed milk','lait condensé','lait concentré','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('poultry','volaille','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('beef','bœuf','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pork','porc','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('veal','veau','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mince','viande hâchée','steak hâché','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mutton','mouton','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('venison','venaison','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lamb','agneau','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cold meat','charcuterie','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sausage','saucisse','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ham','jambon','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bacon','tranche de lard','bacon','lardon',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('gammon','jambon','','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('chicken','poulet','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('turkey','dinde','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('duck','canard','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('beef steak','steak','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pork chop','côtelette de porc','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('goose','oie','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bread','pain','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bread roll','petit pain','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('croissant','croissant','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pastry','pâte','pâtisserie','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bagel','bagel','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('muffin','muffin','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bun','petit pain','pain au lait','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('biscuit','biscuit','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('doughnut','beignet','donut','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cake','gâteau','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pie','tourte','tarte','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sliced bread','pain en tranches','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('crust','croûte','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('loaf of bread','pain','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baguette','baguette','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sandwich','sandwich','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fruit','fruit','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lemon','citron','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('orange','orange','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cherry','cerise','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('apple','pomme','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('watermelon','pastèque','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('melon','melon','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('banana','banane','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('kiwi','kiwi','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pear','poire','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('grapes','raisins','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fig','figue','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('strawberry','fraise','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('raspberry','framboise','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('gooseberry','groseille à maquereau','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('redcurrant','groseille','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('blackberry','mûre','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('grapefruit','pamplemousse','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lime','citron vert','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mango','mangue','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pineapple','ananas','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('coconut','noix de coco','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lychee','litchi','lychee','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mandarine','mandarine','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('clementine','clementine','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tangerine','mandarine','tangerine','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('citrus fruit','agrume','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('plum','prune','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('avocado','avocat','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pomegranate','grenade','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('papaya','papaye','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('blueberry','myrtille','bleuet','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('berry','baie','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('vegetable','légume','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('onion','oignon','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('shallots','échalottes','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('garlic','ail','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('clove','gousse','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('leek','poireau','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('spring onions','oignons printaniers','oignons de printemps','oignons nouveaux',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cabbage','chou','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cauliflower','chou-fleur','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Brussels sprouts','choux de Bruxelles','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('broccoli','brocoli','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('carrot','carotte','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('corn','blé','maïs','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pop corn','pop-corn','pop corn','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sweet corn','maïs','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('potato','pomme de terre','patate','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pumpkin','citrouille','potiron','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bean','haricot','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('green bean','haricot vert','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('peas','petits pois','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sweet potato','patate douce','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('zucchini','courgette','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('marrow','courge','courgette','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('parsley','persil','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('beetroot','betterave','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('turnip','navet','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tomato','tomate','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cherry tomato','tomate cerise','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cucumber','concombre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pepper','poivre','poivron','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('green pepper','poivron vert','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('red pepper','poivron rouge','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('yellow pepper','poivron jaune','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('radish','radis','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('horseradish','raifort','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lettuce','laitue','salade','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('celery','céleri','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mushrooms','champignons','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('aubergine','aubergine','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('artichoke','artichaut','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fennel','fenouil','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('asparagus','asperge','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('parsnip','panais','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('chilli','piment','piment fort','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('crab','crabbe','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('prawn','crevette','gambas','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('shrimp','crevette','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('trout','truite','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fish','poisson','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cod','morue','cabillaud','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('carp','carpe','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('salmon','saumon','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('herring','hareng','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mackerel','maquereau','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mussels','moules','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tuna','thon','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('electric kettle','bouilloire électrique','bouilloire','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('oven glove','gant de four','gant de cuisine','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('wok','wok','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pressure cooker','cuiseur vapeur','autocuiseur','cocotte minute',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('egg cup','coquetier','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('egg timer','sablier','sablier coquetier','sablier-coquetier',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cook','cuisiner','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bake','cuire au four','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('roast','rôtir','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('steam','cuire à la vapeur','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('barbecue','griller au barbecue','cuire au barbecue','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('grill','griller','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('toast','faire griller','faire toaster','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('heat up','réchauffer','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('hard boiled egg','œuf dur','œuf à la coque','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fried egg','œuf au plat','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('poached egg','œuf poché','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('scrambled egg','œufs brouillés','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('eggshell','coquille','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('chocolate','chocolat','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('candy','bonbons','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sweets','bonbons','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('dessert','dessert','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pudding','dessert','pudding','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('rice pudding','riz au lait','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('custard','crème anglaise','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('caramel','caramel','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('starter','entrée','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('breakfast','petit déjeuner','petit-déjeuner','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lunch','déjeuner','repas de midi','pause de midi',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('dinner','dîner','repas du soir','souper',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('supper','souper','dîner','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tea','thé','dîner','souper',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tea','thé','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('coffee','café','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('milk','lait','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('milk shake','lait frappé','milk shake','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fruit juice','jus de fruit','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fizzy drinks','sodas','boissons gazeuses','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mineral water','eau minérale','eau de source','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('still','sans bulles','plate','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sparkling','pétillante','gazeuse','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lemonade','citronade','limonade','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('apple juice','jus de pomme','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('orange juice','jus d''orange','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('coke','coca','coca-cola','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cocoa','cacao','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('hot chocolate','chocolat chaud','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cappuccino','cappuccino','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('soft drink','boisson gazeuse','soda','boisson non alcoolisée',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('carbohydrate','carbohydrate','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('calorie','calorie','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('protein','protéine','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fat','matière grasse','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sugar','sucre','sucres','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pepper','poivre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('salt','sel','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bay leaf','laurier','feuille de laurier','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('marjoram','marjolaine','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('allspice','piment de la Jamaïque','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('curry','curry','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('paprika','paprika','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('oregano','origan','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('vanilla','vanille','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baking powder','levure chimique','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sugar','sucre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('honey','miel','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('marmalade','marmalade','confiture d''orange','confiture d''agrumes',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jam','confiture','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jelly','gelée','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lean','maigre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('smoked','fumé','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('abseil','faire de la descente en rappel','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('attack','attaquer','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('award','décerner','attribuer','récompenser',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('backpack','faire le routard','randonner avec un sac à dos','voyager sac au dos',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('back-pedal','faire machine arrière','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('beat','battre','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('canoe','faire du canoë','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('climb','grimper','escalader','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('compete','concourir','participer à','rivaliser',3,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cycle','faire du vélo','pédaler','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('defend','défendre','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('do aerobics','faire de l''aérobie','faire de l''aérobic','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('dribble','dribbler','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('exercise','faire de l''exercice','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('go by bike','rouler à vélo','se rendre à vélo','aller à vélo',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('go jogging','faire du footing','faire du jogging','faire un footing',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('go swimming','se baigner','nager','faire de la natation',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jog','faire du footing','faire du jogging','faire un footing',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jump','sauter','bondir','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('kick','donner un coup de pied','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pass','passer','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('play baseball','jouer au baseball','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('play basketball','jouer au basket','jouer au basketball','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('play chess','jouer aux échecs','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('play football','jouer au foot','jouer au football','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('play handball','jouer au hand','jouer au handball','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('play hockey','jouer au hockey','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('play rugby','jouer au rugby','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('play volleyball','jouer au volley','jouer au volleyball','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ride a bike','faire du vélo','faire de la bicyclette','monter à vélo',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('row','faire de l''aviron','ramer','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('run','courir','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tackle','tacler','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('walk','marcher','se promener','aller à pied',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('abseiling','descente en rappel','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('acrobatics','acrobatie','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('aerobics','aérobie','aérobic','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('American football','football américain','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('archery','tir à l''arc','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('athletics','athlétisme','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('backpacking','randonnée avec sac à dos','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('backstroke','nage sur le dos','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('badminton','badminton','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('basketball','basket','basketball','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baseball','baseball','base-ball','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('board game','jeu de société','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bodybuilding','musculation','culturisme','bodybuilding',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bowling','bowling','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('boxing','boxe','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('breaststroke','brasse','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('butterfly','nage papillon','papillon','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('canoeing','canoë','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('checkers','pions','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('crawl','crawl','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cricket','cricket','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cycling','cyclisme','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('draughts','jeu de dames','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fencing','escrime','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tennis','tennis','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('football','football','foot','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('golf','golf','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('gymnastics','gymnastique','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('handball','handball','hand','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('hockey','hockey','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('horse racing','courses hippiques','courses de chevaux','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('judo','judo','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('kayaking','kayak','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lacrosse','lacrosse','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('marathon','marathon','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('parachuting','parachutisme','saut en parachute','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('polo','polo','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('rowing','aviron','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('rugby','rugby','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sailing','voile','nautisme','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skateboarding','skateboard','skate','planche à roulettes',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skating','patinage','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skiiing','ski','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skydiving','parachutisme','saut en parachute','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('snowboarding','snowboard','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sprint','sprint','course de vitesse','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('surfing','surf','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('swimming','natation','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('table tennis','tennis de table','ping-pong','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('triathlon','triathlon','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('volleyball','volleyball','volley','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('weightlifting','haltérophilie','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('wingsuit flying','vol en wingsuit','vol en combinaison ailée','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('white-water rafting','rafting en eaux vives','rafting','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('workout','entraînement','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('yoga','yoga','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('arrow','flèche','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('backpack','sac à dos','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ballpark','stade de base-ball','stade de baseball','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baseball','base-ball','baseball','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baseball bat','batte de base-ball','batte de baseball','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baseball glove','gant de base-ball','gant de baseball','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('basket','panier','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('basketball','basketball','basket','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bat','batte','','',3,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bicycle','vélo','bicylette','bécane',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bike','vélo','bicylette','bécane',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bobsleigh','bobsleigh','bobsled','bob',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bow','arc','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('boxing gloves','gants de boxe','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('canoe','canoë','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('exercise bike','bicyclette d''exercice','vélo d''apartement','vélo stationnaire',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('foil','fleuret','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('football','ballon','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('golf club','club de golf','crosse de golf','canne de golf',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('handball','main','ballon de hand','ballon de handball',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('helmet','casque','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('hockey puck','palet de hockey','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('hockey stick','crosse de hockey','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('horse','cheval','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jockey cap','casquette de jockey','casquette jockey','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jump','obstacle','haie','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('kayak','kayak','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mask','masque','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('net','filet','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('paddle','pagaie','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('parachute','parachute','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('rugby ball','ballon de rugby','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('racket','raquette','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('saddle','selle','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sail','voile','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sailboat','voilier','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('shuttlecock','volant','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skateboard','skateboard','skate','planche à roulettes',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skates','patins','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skis','skis','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ski poles','bâtons de ski','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('snowboard','snowboard','planche','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('surfboard','planche de surf','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('swimsuit','maillot de bain','costume de bain','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('swimming cap','bonnet de bain','bonnet de natation','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('swimming trunks','maillot de bain','short de bain','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('target','cible','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tracksuit','survêtement','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('trainers','baskets','chaussures de sport','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('weight','poids','haltères','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('wingsuit','wingsuit','combinaison ailée','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('yacht','yacht','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('acrobat','acrobate','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('adversary','adversaire','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('referee','arbitre','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('archer','archer','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('athlete','athlète','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('attacker','attaquant','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('backpacker','randonner avec sac à dos','routard','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baseplayer','joueur de base','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('biker','motard','vététiste','cycliste',3,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bodybuilder','culturiste','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('boxer','boxeur','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('catcher','catcheur','receveur','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('champion','champion','','',3,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('coach','coach','entraîneur','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('commentator','commentateur','journaliste','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('competitor','compétiteur','','',3,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('contestant','compétiteur','concurrent','participant',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cricketer','joueur de cricket','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cyclist','cycliste','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('defender','défenseur','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fan','fan','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fencer','tireur','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('goalkeeper','gardien de but','goal','gardien',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('gymnast','gymnaste','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jockey','jockey','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('parachutist','parachustiste','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pitcher','lanceur','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('player','joueur','','',3,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('runner','coureur','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skater','patineur','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('skiier','skieur','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ski jumper','sauteur à ski','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sprinter','sprinter','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('supporter','supporteur','supporter','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('surfer','surfeur','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('umpire','arbitre','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('winner','gagnant','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('able-bodied','non handicapé','valide','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ace','as','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('acrobatic','acrobatique','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('adrenalin','adrénaline','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('alpine','alpin','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('amateur','amateur','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ascent','ascension','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('athletic','athlétique','','',3,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('attack','attaque','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('audience','public','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('award','récompense','médaille','prix',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('backhand','revers','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('biceps','biceps','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bikini','bikini','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bronze medal','médaille de bronze','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('championship','championnat','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('checkmate','échec et mat','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('competition','compétition','','',3,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('competitive','compétitif','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('contest','concours','compétition','course',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tournament','tournoi','','',2,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('defence','défense','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('disabled','handicapé','invalide','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('fit','en forme','en bonne santé','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('physical activity','activité physique','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('stadium','stade','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cross country','cross','course de fond','cross-country',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('downhill','descente','','',1,'SPORT');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('anchovies','anchois','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('caviar','caviar','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('crayfish','écrevisse','langouste','languoustine',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lobster','homard','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('octopus','pieuvre','poulpe','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('squid','calmar','calamar','encornet',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('amino acid','aminoacide','acide aminé','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('carbohydrates','glucides','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('vitamins','vitamines','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('calorie','calorie','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cholesterol','cholestérol','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('powdered milk','lait en poudre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('almond','amande','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('brazil nut','noix du Brésil','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cashew','noix de cajou','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('raisin','raisin sec','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('coconut','noix de coco','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ammonia','ammoniaque','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baking powder','levure chimique','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('yeast','levure','levain','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('breadcrumbs','chapelure','miettes de pain','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('icing sugar','sucre glace','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('aniseed','anis','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('basil','basilique','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('chamomile','camomille','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('chive','ciboulette','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('coriander','coriandre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cress','cresson','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('dill','aneth','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('appetite','appétit','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('appetizing','appétissant','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('aroma','arôme','odeur','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('aromatic','aromatique','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('aspic','aspic','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('brown bag lunch','sac repas','sac-repas','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('box lunch','boîte-repas','panier-repas','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('packed lunch','panier-repas','pique-nique','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bite','bouchée','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('have a nice meal','bon appétit','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bone','os','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('breaded','pané','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('caffeine','caféine','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('creamy','crémeux','','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('crisps','chips','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('crispy','croustillant','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('delicious','délicieux','succulent','savoureux',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('dressing','vinaigrette','sauce pour salade','sauce salade',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('yummy','délicieux','bon','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('yucky','dégoûtant','horrible','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('apricot','abricot','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('blackcurrant','cassis','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('artichoke','artichaut','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('asparagus','asperge','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baked beans','haricots à la sauce tomate','haricots en sauce tomate','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baked potato','pomme de terre en robe de chambre','pomme de terre au four','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jacket potato','pomme de terre en robe de chambre','pomme de terre au four','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('green bean','haricot vert','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('soya bean','graine de soja','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('broad bean','fève','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bean sprouts','germes de soja','pousses de soja','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bagel','bagel','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bread and butter','tartine de beurre','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baker','boulanger','','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('apron','tablier','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('banger','saucisse','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('beefburger','steak hâché','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('starter','entrée','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('beverage','boisson','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bill','addition','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('main course','plat principal','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('soup','soupe','potage','consommé',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('dessert','dessert','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('menu','menu','','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('waiter','serveur','garçon','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('waitress','serveuse','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('chef','chef','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cook','cuisinier','cuistot','chef',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('customer','client','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('takeaway','plat à emporter','à emporter','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('order','commande','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pay by credit card','payer par carte bancaire','régler par carte bancaire','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('boiling point','point d''ébullition','ébullition','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('braise','braiser','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bottle opener','ouvre-bouteille','décapsuleur','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('can opener','ouvre-boîte','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tin opener','ouvre-boîte','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('chopsticks','baguettes','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('corkscrew','tire-bouchon','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('crockery','vaisselle','','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('bouillon','bouillon','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('broth','bouillon','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('breakfast','petit-déjeuner','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('lunch','déjeuner','repas de midi','pause de midi',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('brunch','brunch','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('dinner','dîner','repas du soir','souper',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tea','thé','dîner','souper',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('supper','souper','dîner','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('buffet','buffet','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('restaurant','restaurant','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('café','café','bistrot','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('canteen','cantine','','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('diner','restaurant','bistrot','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('buffet car','wagon-restaurant','voiture-bar','voiture bar',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('butcher''s','chez le boucher','boucherie','',2,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('cafeteria','cafétéria','cantine','',3,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('coffee bar/shop','café','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('delicatessen','charcuterie','épicerie fine','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('can','boîte','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tin','boîte','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('carafe','carafe','','',1,'FOOD');
INSERT INTO `FRENCH` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('carton','brique','carton','',1,'FOOD');
DROP TABLE IF EXISTS "IMAGES";
CREATE TABLE "IMAGES" (
	`WORD`	TEXT NOT NULL,
	`TL1`	TEXT NOT NULL,
	`TL2`	TEXT,
	`TL3`	TEXT,
	`NIVEL`	INTEGER NOT NULL,
	`TIPO`	TEXT NOT NULL
);
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('sieve','peeler','colander','grater',1,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('peeler','grater','whisk','ladle',2,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('grater','peeler','mortar and pestle','masher',3,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('whisk','ladle','hob','sieve',3,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('baking pan','tray','drainer','colander',2,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('ladle','pie slice','masher','soup spoon',4,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('jug','pot','drainer','colander',2,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('tray','drainer','baking pan','platter',1,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mincer','masher','whisk','mortar and pestle',4,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('masher','mincer','grater','scales',5,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('pie slice','ladle','peeler','steel',5,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('drainer','baking pan','tray','hob',2,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('corkscrew','mortar and pestle','tin opener','rolling pin',4,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('mortar and pestle','masher','rolling pin','jug',5,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('colander','sieve','baking pan','saucepan',5,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('hob','oven','stove','work top',4,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('oven','hob','stove','cooker',4,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('scales','mortar and pestle','steel','corkscrew',3,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('rolling pin','steel','pie slice','sieve',3,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('steel','corkscrew','mincer','ladle',5,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Boxing','Fighting','Wrestling','Kicking',1,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('American Football','Soccer','Football','Basketball',2,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Football','Ball kicking','Handball','Basketball',1,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Chequered Flag','Square Flag','Rounded Flag','White and black flag',5,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Volley shot','Free kick','Snapshot','Penalty kick',3,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Mountain bike','Touring bicycle','Flat bike','Motorbike',2,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Racquet','Rocket','Raquet','Racket',1,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Hockey','Hoquey','Jockey','Hoky',1,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Swimming','Smiling','Snorkelling','Scuba diving',3,'FOOD/SPORT');
INSERT INTO `IMAGES` (WORD,TL1,TL2,TL3,NIVEL,TIPO) VALUES ('Scuba diving','Swimming','Snorkelling','Breathing',4,'FOOD/SPORT');