package cn.ntboy.service;

import cn.ntboy.model.Notice;

import java.util.List;

public interface NoticeService {

    ServiceResultState<List<Notice>> getAllNotice();

    ServiceResultState<Notice> newNotice(Notice notice);
}
