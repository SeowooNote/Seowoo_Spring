package com.seowoo.basic.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seowoo.basic.entity.UserEntity;
import com.seowoo.basic.repository.UserRepository;
import com.seowoo.basic.service.MainService;

import lombok.RequiredArgsConstructor;

// description : Service - 레이어드 아키텍처 상의 비즈니스 영역 //
// description : 실제 비즈니스 로직(연상, 유효성 검사...)이 작성되는 구역 //

// description : @Service - 해당 클래스가 Service 영역임을 명시 //
// description : @Component 를 포함하고 있어서 Spring Bean 으로 등록할 수 있음 //
// description : Spring Bean 으로 등록해야 Spring 에게 IoC 할 수 있음 //
@Service
@RequiredArgsConstructor
public class MainServiceImplement implements MainService {

     private final UserRepository userRepository;

     @Override
     public String hello() {
          UserEntity userEntity = new UserEntity("email@email.com", "0123456789", "nickname", "01012345678", "대한민국", "서울특별시", null);
          userRepository.save(userEntity);
          return "Hello World";
     }

     @Override
     public String getRepository() {
          List<UserEntity> userEntity = userRepository.findByNicknameOrAddress("nickname", "서울특별시");
          return userEntity.toString();
     }

     
     
}
