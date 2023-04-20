package moe.orangemc.orangebench.resourcepack;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import moe.orangemc.orangebench.OrangeBenchPlugin;
import moe.orangemc.orangebench.config.resourcepack.ResourcePackConfig;
import moe.orangemc.orangebench.util.SneakyExceptionThrower;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;

public class ResourcePackServer {
    private final Server server;
    private final ResourcePackConfig config;

    public ResourcePackServer(ResourcePackConfig config) {
        this.config = config;

        this.server = new Server(new InetSocketAddress(config.getDistributorConfig().getHost(), config.getDistributorConfig().getPort()));
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(config.getDistributorConfig().getPort());
        server.setConnectors(new Connector[]{connector});
        try {
            server.start();
        } catch (Exception e) {
            SneakyExceptionThrower.throwException(e);
        }
    }

    private class ResourcePackServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Player p = Bukkit.getPlayer(req.getHeader("X-Minecraft-Username"));
            if (p == null) {
                resp.sendError(403, "You should log into the server first.");
                return;
            }

            File resourcePackFile = new File(OrangeBenchPlugin.getInstance().getDataFolder(), config.getDistributorConfig().getPath());
            if (!resourcePackFile.exists()) {
                resp.setContentType("text/plain");
                resp.sendError(500, "Server failed to generate a resource pack file.");
                p.kick(Component.text("An error occurred while generating a resource pack file for you. If you are a server administrator, please check the console.", NamedTextColor.RED));
                return;
            }

            resp.setContentType("application/octet-stream");
            resp.setStatus(HttpServletResponse.SC_OK);
            try (FileInputStream fis = new FileInputStream(resourcePackFile)) {
                IOUtils.copy(fis, resp.getOutputStream());
            }
        }
    }
}
