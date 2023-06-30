package io.github.dropwizard;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.lifecycle.Managed;

public class LockFileManager implements Managed {

    private static final Logger LOGGER = LoggerFactory.getLogger(LockFileManager.class);
    
    private Path path;

    public LockFileManager(String path) {
        this.path = FileSystems.getDefault().getPath(path);
    }

    @Override
    public void start() throws Exception {
        // throw new UnsupportedOperationException("Unimplemented method 'start'");
        LOGGER.info("Staring the watch service...");
        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) { 
            final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY); 
            while (true) { 
                final WatchKey wk = watchService.take(); 
                for (WatchEvent<?> event : wk.pollEvents()) { 
                    // We only register "ENTRY_MODIFY" so the context is always a Path. 
                    final Path changed = (Path) event.context(); 
                    LOGGER.info("ENTRY_MODIFY event for {}", changed.toString());
                    if (changed.endsWith("myFile.txt")) { 
                        LOGGER.info("My file has changed"); 
                    } 
                } 
                // Reset the key 
                boolean valid = wk.reset(); 
                if (!valid) { 
                    LOGGER.info("Watch key: {} has been unregistered", wk); 
                } 
            }
        }
    }

    @Override
    public void stop() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }
    
}
