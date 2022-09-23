package com.jukoz.racesplugin.Races;

import com.jukoz.racesplugin.Race;

public enum AvailableRacesEnum {
    NONE("None"),
    ELF("Elf"),
    DWARF("Dwarf"),
    HUMAN("Human"),
    HOBBIT("Hobbit"),
    ORC("Orc"),
    URUK("Uruk"),
    NAZGUL("Nazgul"),
    WIZARD("Wizard"),
    TROLL("Troll");

    private final String name;

    AvailableRacesEnum(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Race getRace(AvailableRacesEnum name){
        switch (name) {
            case ELF:
                //return Elf.getInstance();
            case DWARF:
                //return Dwarf.getInstance();
            case HUMAN:
                //return Human.getInstance();
            case HOBBIT:
                //return Hobbit.getInstance();
            case ORC:
                return Orc.getInstance();
            case URUK:
                //return Uruk.getInstance();
            case NAZGUL:
                //return Nazgul.getInstance();
            case WIZARD:
                //return Wizard.getInstance();
            case TROLL:
                //return Troll.getInstance();
            default:
                return null;
        }
    }
}
