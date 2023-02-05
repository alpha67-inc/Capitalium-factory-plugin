package capitaliumfactory.capitalium.events;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.world.ChunkLoadEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OnChunkLoad implements Listener {

    @EventHandler
    public void breakEvent(ChunkLoadEvent e) throws IOException {
        Chunk chunk= e.getChunk();

        int cX = chunk.getX() * 16; // make it a world coordinate...
        int cZ = chunk.getZ() * 16;
        World world = chunk.getWorld();

        for(int x = 0; x < 16; x++)
        {
            for(int z = 0; z < 16; z++)
            {
                world.setBiome(cX + x, cZ+ z, Biome.SNOWY_PLAINS);
                addLine(cX + x, cZ+ z, chunk);
            }
        }

    }

    public static void addLine(int x, int y, Chunk chunk) throws IOException {
        File csvFile = new File("data.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(csvFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder line = new StringBuilder();
        line.append(x+","+y+","+chunk+",");

        line.append("\n");
        fileWriter.write(line.toString());

        fileWriter.close();

    }
}
