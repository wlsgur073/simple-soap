package com.example.soap;

import com.example.user.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class UserRepository {
    // 간단한 인메모리 저장소 예제 (실제 환경에서는 Service, Repository를 주입해서 사용)
    private final ConcurrentMap<String, User> userStore = new ConcurrentHashMap<>();

    public UserRepository() {
        User u1 = new User();
        u1.setUserId(String.valueOf(1L));
        u1.setUserName("홍길동");
        u1.setEmail("hong1@example.com");
        u1.setPhoneNumber("010-1234-5678");

        User u2 = new User();
        u2.setUserId(String.valueOf(2L));
        u2.setUserName("임꺽정");
        u2.setEmail("lim@example.com");
        u2.setPhoneNumber("010-8765-4321");

        User u3 = new User();
        u3.setUserId(String.valueOf(3L));
        u3.setUserName("이몽룡");
        u3.setEmail("lee@example.com");
        u3.setPhoneNumber("010-1111-2222");

        userStore.put(u1.getUserId(), u1);
        userStore.put(u2.getUserId(), u2);
        userStore.put(u3.getUserId(), u3);
    }

    public User getUserById(String userId) {
                return userStore.get(userId);
    }
}
