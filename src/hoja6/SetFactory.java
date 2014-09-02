/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author manuelgomez
 */
public class SetFactory<T> {
    public Set<T>getClass(String tipoSet){
        switch (tipoSet){
            case "Hash":
                return new HashSet<T>();
            case "Tree":
                return new TreeSet<T>();
            case "Linked":
                return new LinkedHashSet<T>();
        }
        return null;
    }
    
}
