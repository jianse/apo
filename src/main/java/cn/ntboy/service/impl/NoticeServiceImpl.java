package cn.ntboy.service.impl;

import cn.ntboy.model.Notice;
import cn.ntboy.model.NoticeExample;
import cn.ntboy.repository.NoticeMapper;
import cn.ntboy.repository.NoticeMapperCustom;
import cn.ntboy.service.NoticeService;
import cn.ntboy.service.ServiceResultState;
import cn.ntboy.util.InjectMapper;
import cn.ntboy.util.tx.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @InjectMapper
    public void setNoticeMapper(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    private NoticeMapper noticeMapper = null;


    private NoticeMapperCustom noticeMapperCustom = null;

    @Override
    public ServiceResultState<List<Notice>> getAllNotice() {
        NoticeExample example = new NoticeExample();
        example.createCriteria().andIdIsNotNull();
        List<Notice> notices = noticeMapper.selectByExample(example);
        return ServiceResultState.wrap(200,notices);
    }

    @Override
    public ServiceResultState<Notice> newNotice(Notice notice) {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(time);
        notice.setTimes(dateStr);
        Integer integer = noticeMapperCustom.insertSelectKey(notice);
        return ServiceResultState.wrap(200,notice);
    }

    @InjectMapper
    public void setNoticeMapperCustom(NoticeMapperCustom noticeMapperCustom) {
        this.noticeMapperCustom = noticeMapperCustom;
    }
}
