package edu.dalhousie.business.sportnomination;

import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.models.SportsNominationModel;
import edu.dalhousie.presentation.StudentView;

import java.util.Calendar;

public class SportsNomination
{
    StudentView view;
    StudentMainClass studentMenu;
    SportsNominationModel sportsNominationModel;

    public SportsNomination()
    {
        view = new StudentView();
        studentMenu = new StudentMainClass();
        sportsNominationModel = new SportsNominationModel();
    }

    public void sportsNomination()
    {
        int overallScore = 0;

        view.showMessage("1. Enter your username: ");
        sportsNominationModel.setUsername(view.getString());

        view.showMessage("2. Enter the name of sport: ");
        sportsNominationModel.setSport(view.getString());

        view.showMessage("3. Enter the number of awards received in this sport: (if you have not received any award please enter '0')");
        sportsNominationModel.setAwards(view.getInt());

        view.showMessage("4. Enter the highest level of achievement received: (0: None, 1: International, 2: National, 3: State, 4: District) ");
        sportsNominationModel.setAchievementLevel(view.getInt());

        view.showMessage("5. Enter the medal received: (0: None, 1: Gold, 2: Silver, 3: Bronze) ");
        sportsNominationModel.setMedal(view.getInt());

        view.showMessage("6. Enter the year in which you have received your last medal: ");
        sportsNominationModel.setYear(view.getInt());

        view.showMessage("\nChecking your eligibility for procuring a spot in the club...");

        sportsNominationModel.setMaxGapYear(2016);
        if (sportsNominationModel.getYear() <= sportsNominationModel.getMaxGapYear())
        {
            view.showMessage("\nSorry! You are not eligible since you have more than 5 years of gap being an active participant in sports activities.");
            goBack();
        }
        else
        {
            if(sportsNominationModel.getAwards() > 6)
            {
                overallScore += 6;
            }
            else
            {
                overallScore += sportsNominationModel.getAwards();
            }

            sportsNominationModel.setLevelZero(0);
            sportsNominationModel.setLevelOne(1);
            sportsNominationModel.setLevelTwo(2);
            sportsNominationModel.setLevelThree(3);
            sportsNominationModel.setLevelFour(4);

            if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelZero())
            {
                overallScore += sportsNominationModel.getLevelZero();
            }
            else if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelOne())
            {
                overallScore += 8;
            }else if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelTwo())
            {
                overallScore += 6;
            }else if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelThree())
            {
                overallScore += 4;
            }else if(sportsNominationModel.getAchievementLevel() == sportsNominationModel.getLevelFour())
            {
                overallScore += 2;
            }

            if (sportsNominationModel.getMedal() == sportsNominationModel.getLevelZero())
            {
                overallScore += sportsNominationModel.getLevelZero();
            }
            else if(sportsNominationModel.getMedal() == sportsNominationModel.getLevelOne())
            {
                overallScore += 6;
            }else if(sportsNominationModel.getMedal() == sportsNominationModel.getLevelTwo())
            {
                overallScore += 4;
            }else if(sportsNominationModel.getMedal() == sportsNominationModel.getLevelThree())
            {
                overallScore += 2;
            }

            sportsNominationModel.setCurrentYear(Calendar.getInstance().get(Calendar.YEAR));
            sportsNominationModel.setYearPoints(sportsNominationModel.getCurrentYear()-sportsNominationModel.getYear());
            overallScore -= sportsNominationModel.getYearPoints();

        }

        //System.out.println(overallScore);

        if(overallScore >= 10)
        {
            view.showMessage("\nCongratulations! You are eligible to be a part of our " + sportsNominationModel.getSport() + " sports club.");
            goBack();
        }
        else
        {
            view.showMessage("\nSorry! You are not eligible since you have more than 5 years of gap being an active participant in sports activities.");
            goBack();
        }
    }

    public void goBack()
    {
        view.showMessage("\nPress '0' to go back");
        int userChoice = view.getInt();
        if (userChoice == 0)
        {
            try
            {
                studentMenu.displayStudentMenu();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void viewSportsNomination()
    {
        String title = "Nomination for Sports";
        //Utility.printHeadingForTheScreen(title, 38);

        sportsNomination();
    }

    public static void main(String[] args)
    {
        SportsNomination sn = new SportsNomination();
        sn.sportsNomination();
    }
}
