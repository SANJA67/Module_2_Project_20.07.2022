package com.ru.javarush.second_project.island_model.factory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.animal.herbivores.*;
import com.ru.javarush.second_project.island_model.game_objects.animal.predatory.*;

public class MyInstance {
    public void start(Animal animal) {
        Wolf wolf = whoAreYouWolf(animal);

        if (wolf == null) {
            Boa boa = whoAreYouBoa(animal);
            if (boa == null) {
                Fox fox = whoAreYouFox(animal);
                if (fox == null) {
                    Bear bear = whoAreYouBear(animal);
                    if (bear == null) {
                        Eagle eagle = whoAreYouEagle(animal);
                        if (eagle == null) {
                            Horse horse = whoAreYouHorse(animal);
                            if (horse == null) {
                                Deer deep = whoAreYouDeep(animal);
                                if (deep == null) {
                                    Rabbit rabbit = whoAreYouRabbit(animal);
                                    if (rabbit == null) {
                                        Mouse mouse = whoAreYouMouse(animal);
                                        if (mouse == null) {
                                            Goat goat = whoAreYouGoat(animal);
                                            if (goat == null) {
                                                Sheep sheep = whoAreYouSheep(animal);
                                                if (sheep == null) {
                                                    Boar boar = whoAreYouBoar(animal);
                                                    if (boar == null) {
                                                        Buffalo buffalo = whoAreYouBuffalo(animal);
                                                        if (buffalo == null) {
                                                            Duck duck = whoAreYouDuck(animal);
                                                            if (duck == null) {
                                                                Caterpillar caterpillar = whoAreYouCaterpillar(animal);
                                                                if (caterpillar == null) {
                                                                    System.out.println("Такого животного нет");
                                                                } else {
                                                                    System.out.println("caterpillar");
                                                                }
                                                            } else {
                                                                System.out.println("duck");
                                                            }
                                                        } else {
                                                            System.out.println("buffalo");
                                                        }
                                                    } else {
                                                        System.out.println("boar");
                                                    }
                                                } else {
                                                    System.out.println("sheep");
                                                }
                                            } else {
                                                System.out.println("goat");
                                            }
                                        } else {
                                            System.out.println("mouse");
                                        }
                                    } else {
                                        System.out.println("rabbit");
                                    }
                                } else  {
                                    System.out.println("deep");
                                }
                            } else {
                                System.out.println("horse");
                            }
                        } else {
                            System.out.println("eagle");
                        }
                    } else {
                        System.out.println("bear");
                    }
                } else {
                    System.out.println("fox");
                }
            } else {
                System.out.println("boa");
            }
        } else {
            System.out.println("wolf");
        }
    }

    public Wolf whoAreYouWolf(Animal animal) {
        if (animal instanceof Wolf wolf) {
            return wolf;
        }
        return null;
    }

    public Boa whoAreYouBoa(Animal animal) {
        if (animal instanceof Boa boa) {
            return boa;
        }
        return null;
    }

    public Fox whoAreYouFox(Animal animal) {
        if (animal instanceof Fox fox) {
            return fox;
        }
        return null;
    }

    public Bear whoAreYouBear(Animal animal) {
        if (animal instanceof Bear bear) {
            return bear;
        }
        return null;
    }public Eagle whoAreYouEagle(Animal animal) {
        if (animal instanceof Eagle eagle) {
            return eagle;
        }
        return null;
    }

    public Horse whoAreYouHorse(Animal animal) {
        if (animal instanceof Horse horse) {
            return horse;
        }
        return null;
    }

    public Deer whoAreYouDeep(Animal animal) {
        if (animal instanceof Deer deer) {
            return deer;
        }
        return null;
    }

    public Rabbit whoAreYouRabbit(Animal animal) {
        if (animal instanceof Rabbit rabbit) {
            return rabbit;
        }
        return null;
    }

    public Mouse whoAreYouMouse(Animal animal) {
        if (animal instanceof Mouse mouse) {
            return mouse;
        }
        return null;
    }

    public Goat whoAreYouGoat(Animal animal) {
        if (animal instanceof Goat goat) {
            return goat;
        }
        return null;
    }

    public Sheep whoAreYouSheep(Animal animal) {
        if (animal instanceof Sheep sheep) {
            return sheep;
        }
        return null;
    }public Boar whoAreYouBoar(Animal animal) {
        if (animal instanceof Boar boar) {
            return boar;
        }
        return null;
    }

    public Buffalo whoAreYouBuffalo(Animal animal) {
        if (animal instanceof Buffalo buffalo) {
            return buffalo;
        }
        return null;
    }

    public Duck whoAreYouDuck(Animal animal) {
        if (animal instanceof Duck duck) {
            return duck;
        }
        return null;
    }

    public Caterpillar whoAreYouCaterpillar(Animal animal) {
        if (animal instanceof Caterpillar caterpillar) {
            return caterpillar;
        }
        return null;
    }

    private static MyInstance myInstance;

    private MyInstance() {
    }

    public static synchronized MyInstance getSettings() {
        if (myInstance == null) {
            myInstance = new MyInstance();
            return myInstance;
        }
        return myInstance;
    }
}
