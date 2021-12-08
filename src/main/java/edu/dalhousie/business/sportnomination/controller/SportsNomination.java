package edu.dalhousie.business.sportnomination.controller;

import edu.dalhousie.business.sportnomination.constants.SportsNominationConstants;
import edu.dalhousie.business.sportnomination.model.ISportsNominationModel;
import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.PrintHeading;

import java.util.Calendar;

public class SportsNomination implements ISportsNomination
{
    IStudentView view = StudentView.getInstance();
    StudentMainClass studentMenu;
    ISportsNominationModel sportsNominationModel = SportsNominationFactory.initialize().getSportsNominationModel();

    public SportsNomination()
    {
        studentMenu = new StudentMainClass();
    }

    public void sportsNomination()
    {
        int overallScore = 0;

        view.showMessage(SportsNominationConstants.enterUsername);
        sportsNominationModel.setUsername(view.getString());

        view.showMessage(SportsNominationConstants.enterSportName);
        sportsNominationModel.setSport(view.getString());

        view.showMessage(SportsNominationConstants.enterAwards);
        sportsNominationModel.setAwards(view.getInt());

        view.showMessage(SportsNominationConstants.enterAchievement);
        sportsNominationModel.setAchievementLevel(view.getInt());

        view.showMessage(SportsNominationConstants.enterMedal);
        sportsNominationModel.setMedal(view.getInt());

        view.showMessage(SportsNominationConstants.enterYear);
        sportsNominationModel.setYear(view.getInt());

        view.showMessage(SportsNominationConstants.checkingEligibility);

        sportsNominationModel.setMaxGapYear(2016);
        if (sportsNominationModel.getYear() <= sportsNominationModel.getMaxGapYear())
        {
            view.showMessage(SportsNominationConstants.notEligibleGap);
            //goBack();
        }
        else
        {
            if(sportsNominationModel.getAwards() > 6)
            {
                overallScore += 10;
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

        if(overallScore >= 10)
        {
            view.showMessage(SportsNominationConstants.eligible + sportsNominationModel.getSport() + SportsNominationConstants.eligibleClub);
        }
        else
        {
            view.showMessage(SportsNominationConstants.notEligible);
        }
        //goBack();
    }

    /*public void goBack()
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
    }*/

    public void viewSportsNomination()
    {
        PrintHeading.printHeadingForTheScreen(SportsNominationConstants.sportsNominationTitle, 38);
        sportsNomination();
    }

    /*public static void main(String[] args)
    {
        SportsNomination sn = new SportsNomination();
        sn.viewSportsNomination();
    }*/
}
