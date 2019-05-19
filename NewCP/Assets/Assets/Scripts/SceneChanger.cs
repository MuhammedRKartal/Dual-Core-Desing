using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneChanger : MonoBehaviour
{
    public static bool isB = true;
    public static int levelCounter = 1;
    public static int transfergold = 0;




    public void toForgePage()
    {
        SceneManager.LoadScene("ForgePage");
    }
    public void toTheBar()
    {
        SceneManager.LoadScene("TheBar");
    }
    public void toTheCityWin()
    {
        transfergold= 20;
        levelCounter++;
        Debug.Log("Level : " + levelCounter);
        SceneManager.LoadScene("TheCity");

    }
    public void toTheCityLost()
    {

        SceneManager.LoadScene("TheCity");

    }


    public void ArenaButton()
    {

        //level 1 
        if (isB && levelCounter==1)
        {
            SceneManager.LoadScene("Scene1_Dialog_(B)");
        }
        else if(isB==false && levelCounter==1)
        {
            SceneManager.LoadScene("Scene1_Dialog_(E)");
        }
        //level 2
        if (isB && levelCounter == 2)
        {
            SceneManager.LoadScene("Scene2_Dialog_(B)");
        }
        else if (isB == false && levelCounter == 2)
        {
            SceneManager.LoadScene("Scene2_Dialog_(E)");
        }
        //level 3
        if (isB && levelCounter == 3)
        {
            SceneManager.LoadScene("Scene3_Dialog_(B)");
        }
        else if (isB == false && levelCounter == 3)
        {
            SceneManager.LoadScene("Scene3_Dialog_(E)");
        }
        //level 4
        if (isB && levelCounter == 4)
        {
            SceneManager.LoadScene("Scene4_Dialog_(B)");
        }
        else if (isB == false && levelCounter == 4)
        {
            SceneManager.LoadScene("Scene4_Dialog_(E)");
        }

    }



}
