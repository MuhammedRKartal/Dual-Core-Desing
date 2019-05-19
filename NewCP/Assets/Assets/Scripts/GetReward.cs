using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class GetReward : MonoBehaviour
{
    private void Start()
    {
        LoadInfo.LoadAllInfo();
    }
    public void getReward()
    {

        GameInfo.Gold += SceneChanger.transfergold;
        SaveInfo.SaveAllInfo();
        Debug.Log(GameInfo.Gold);
    }
}
