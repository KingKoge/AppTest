package com.ssru.mrsmile.apptest.manager;

import com.ssru.mrsmile.apptest.dao.BloggerDao;
import com.ssru.mrsmile.apptest.dao.BloggerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Smile on 5/26/2016.
 */
public class BloggerDaoManager {

    private BloggerDao tempDao;
    private BloggerDao dao;

    public void setDao(BloggerDao dao) {
        this.tempDao = dao;
        sortDao();
    }

    private void sortDao() {
        dao = tempDao;
        List<String> listLabel = getListLabelType();
        List<BloggerItem> tempItem = new ArrayList<>();

        for (String label : listLabel) {
            for (BloggerItem item : tempDao.getBloggerItems()) {
                if (label.equalsIgnoreCase(item.getLabels().get(0))) {
                    tempItem.add(item);
                }
            }
        }
        dao.setBloggerItems(tempItem);
    }

    private List<String> getListLabelType() {
        List<String> listLabel = new ArrayList<>();

        for (BloggerItem item : tempDao.getBloggerItems()) {
            int count = 0;
            String itemLabel = item.getLabels().get(0);
            if (listLabel.size() == 0) {
                listLabel.add(itemLabel);
            } else {
                for (String label : listLabel) {
                    if (label.equalsIgnoreCase(itemLabel)) {
                        count++;
                    }
                }
                if (count == 0) {
                    listLabel.add(itemLabel);
                }
            }
        }

        return listLabel;
    }

    public BloggerDao getDao(){
        return dao;
    }
}
