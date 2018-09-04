package com.skill_centric.objectbox;

import io.objectbox.converter.PropertyConverter;

public class GenderConverter implements PropertyConverter<Gender, String> {

    @Override
    public Gender convertToEntityProperty(String databaseValue) {

        if(databaseValue.equals("male"))
            return Gender.MALE;
        else if(databaseValue.equals("female"))
            return Gender.FEMALE;

        return null;
    }

    @Override
    public String convertToDatabaseValue(Gender entityProperty) {

        switch (entityProperty) {

            case MALE:
                return "male";
            case FEMALE:
                return "female";
        }

        return null;
    }
}
