package com.example.inf1030_tp1.Data.Repo;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import com.example.inf1030_tp1.Data.DAO.SyncInfoDAO;
import com.example.inf1030_tp1.MainApp;
import com.example.inf1030_tp1.Models.SyncInfo;

import java.time.LocalDateTime;
import java.util.List;

public class SyncRepository {
    private final SyncInfoDAO dao;
    private MainApp app;
    public SyncRepository(Application context){
        this.app = (MainApp) context;
        dao = app.getDb().syncInfoDAO();
    }

    public LiveData<List<SyncInfo>> liveAll(){
        return  dao.getLiveAll();
    }
    public LiveData<List<SyncInfo>>liveDirty(){
        return  dao.getLiveDirty();
    }

    public LiveData<SyncInfo>live(String name){
        return  dao.getLive(name);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void save(@Nullable SyncInfo info, @Nullable  Class<?> entityClass, Runnable completion) {
        String name;
        if(entityClass != null) {
            name = entityClass.getSimpleName().toLowerCase();
            app.dbPost(()->{
                SyncInfo entity = dao.get(name);
                if(entity == null){
                    entity = new SyncInfo();
                    entity.setEntity(name);
                    entity.setCreated(LocalDateTime.now());
                }
                entity.setUpdated(LocalDateTime.of(1970,01, 01,0,0,0,0));
                entity.setDirty(true);
                dao.insert(entity);
                if(completion != null) {
                    new Handler(Looper.getMainLooper()).post(completion);
                }
            });
        }else{
            update(completion, info);
        }
    }
    private void save(Runnable completion, SyncInfo syncInfos){

        app.dbPost(()->{
            dao.insert(syncInfos);
            if(completion != null) {
                new Handler(Looper.getMainLooper()).post(completion);
            }

        });

    }
    private void update(Runnable completion, SyncInfo... syncInfos){
        app.dbPost(()->{
            dao.update(syncInfos);
            if(completion != null) {
                new Handler(Looper.getMainLooper()).post(completion);
            }

        });

    }

    public void delete(SyncInfo... syncInfos) {
        delete(null, syncInfos);
    }
    public void delete(Runnable completion, SyncInfo... syncInfos){
        app.dbPost(()->{
            dao.delete(syncInfos);

            if(completion != null) {
                new Handler(Looper.getMainLooper()).post(completion);
            }

        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void requestSync(String name) {

        app.dbPost(()->{
            SyncInfo entity = dao.get(name);
            if(entity == null){
                entity = new SyncInfo();
                entity.setEntity(name);
                entity.setCreated(LocalDateTime.now());
            }
            entity.setDirty(true);
            dao.insert(entity);

        });

    }
}
