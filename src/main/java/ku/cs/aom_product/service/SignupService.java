
package ku.cs.aom_product.service;

import ku.cs.aom_product.entity.Member;
import ku.cs.aom_product.model.SignupRequest;
import ku.cs.aom_product.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private MemberRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username){
        return  repository.findByUsername(username) == null ;
    }
    public void createUser(SignupRequest user){
        Member record = modelMapper.map(user, Member.class);
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);
        repository.save(record);
    }

    public Member getUser(String username){
        return  repository.findByUsername(username);
    }
}
