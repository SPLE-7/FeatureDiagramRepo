package LibraryManagementSystem.daftarbuku.bukufisik;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.daftarbuku.core.DaftarBukuServiceDecorator;
import LibraryManagementSystem.daftarbuku.core.DaftarBukuImpl;
import LibraryManagementSystem.daftarbuku.core.DaftarBukuServiceComponent;

public class DaftarBukuServiceImpl extends DaftarBukuServiceDecorator {
    public DaftarBukuServiceImpl (DaftarBukuServiceComponent record) {
        super(record);
    }

    
}
