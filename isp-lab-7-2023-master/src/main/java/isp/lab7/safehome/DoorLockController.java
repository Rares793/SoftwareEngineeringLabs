package isp.lab7.safehome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;

public class DoorLockController implements ControllerInterface {
    private final Map<Tenant, AccessKey> validAccess = new HashMap<>();
    private final ArrayList<AccessLog> accessLogs = new ArrayList<>();
    private final Door door;
    private int attempts = 0;

    public DoorLockController(Door door) {
        this.door = door;
    }

    @Override
    public DoorStatus enterPin(String pin) throws Exception {
        if(pin.equals(ControllerInterface.MASTER_KEY)) {
            attempts = 0;
            door.unlockDoor();
            accessLogs.add(new AccessLog("Admin", LocalDateTime.now(), "Master pin entered", DoorStatus.OPEN, "Null"));
            return DoorStatus.OPEN;
        }
        AccessKey accessKeyFromPin = new AccessKey(pin);
        String tenantName = "Unknown";
        for(Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
            if(entry.getValue().equals(accessKeyFromPin)) {
                tenantName = entry.getKey().getName();
            }
        }
        if(attempts >= 2) {
            door.lockDoor();
            accessLogs.add(new AccessLog(tenantName, LocalDateTime.now(), "Pin entered", DoorStatus.CLOSE, "Too many attempts"));
            throw new TooManyAttemptsException("Too many attempts!");
        }
        if(!validAccess.containsValue(accessKeyFromPin)) {
            attempts++;
            accessLogs.add(new AccessLog(tenantName, LocalDateTime.now(), "Pin entered", DoorStatus.CLOSE, "Invalid pin"));
            throw new InvalidPinException("Invalid pin! Try again.");
        }
        if(door.getStatus() == DoorStatus.OPEN) {
            attempts = 0;
            door.lockDoor();
            accessLogs.add(new AccessLog(tenantName, LocalDateTime.now(), "Pin entered", DoorStatus.CLOSE, "Null"));
            return DoorStatus.CLOSE;
        }
        door.unlockDoor();
        accessLogs.add(new AccessLog(tenantName, LocalDateTime.now(), "Pin entered", DoorStatus.OPEN, "Null"));
        return DoorStatus.OPEN;
    }

    @Override
    public void addTenant(String pin, String name) throws Exception {
        AccessKey accessKey = new AccessKey(pin);
        Tenant tenant = new Tenant(name);
        if(validAccess.containsKey(tenant)) {
            accessLogs.add(new AccessLog(name, LocalDateTime.now(), "Adding new tenant", DoorStatus.OPEN, "Tenant already exists"));
            throw new TenantAlreadyExistsException("Tenant already exists!");
        }
        accessLogs.add(new AccessLog(name, LocalDateTime.now(), "Adding new tenant", DoorStatus.OPEN, "Null"));
        validAccess.put(tenant, accessKey);
    }

    @Override
    public void removeTenant(String name) throws Exception {
        Tenant tenant = new Tenant(name);
        if(!validAccess.containsKey(tenant)) {
            accessLogs.add(new AccessLog(name, LocalDateTime.now(), "Removing tenant", DoorStatus.CLOSE, "Tenant does not exist"));
            throw new TenantNotFoundException("Tenant not found!");
        }
        accessLogs.add(new AccessLog(name, LocalDateTime.now(), "Removing tenant", DoorStatus.CLOSE, "Null"));
        validAccess.remove(tenant);
    }

    public ArrayList<AccessLog> getAccessLogs() {
        return accessLogs;
    }
}

