package edu.dalhousie.business.sportnomination.model;

public interface ISportsNominationModel {

    String getUsername();

    void setUsername(String username);

    String getSport();

    void setSport(String sport);

    int getAwards();

    void setAwards(int awards);

    int getAchievementLevel();

    void setAchievementLevel(int achievementLevel);

    int getMedal();

    void setMedal(int medal);

    int getYear();

    void setYear(int year);

    int getMaxGapYear();

    void setMaxGapYear(int maxGapYear);

    int getCurrentYear();

    void setCurrentYear(int currentYear);

    int getYearPoints();

    void setYearPoints(int yearPoints);

    int getLevelZero();

    void setLevelZero(int levelZero);

    int getLevelOne();

    void setLevelOne(int levelOne);

    int getLevelTwo();

    void setLevelTwo(int levelTwo);

    int getLevelThree();

    void setLevelThree(int levelThree);

    int getLevelFour();

    void setLevelFour(int levelFour);
}
