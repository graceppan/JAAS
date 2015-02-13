/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 *
 * @author Xpan
 */
public class HashedPasswordGenerator {

    public String generateHash(String password) {
        return Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
    }

    public String hashPassword(String password) {
        return generateHash(password);
    }
}
