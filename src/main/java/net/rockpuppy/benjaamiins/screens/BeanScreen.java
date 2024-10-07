package net.rockpuppy.benjaamiins.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;

public class BeanScreen extends HandledScreen<BeanstoneMonolithScreenHandler> {
    private static final Identifier BG_TEXTURE = Identifier.of(Benjaamiins.MOD_ID, "textures/gui/monolith.png");
    static int bgWidth = 256;
    static int bgHeight = 184;
    static int imgWidth = 236;
    static int imgHeight = 134;
    public ButtonWidget button1;
    public ButtonWidget button2;
    private int currentPage = 1;
    private final int totalPages = 5;

    public BeanScreen(BeanstoneMonolithScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BG_TEXTURE);
        int x = (width - bgWidth) / 2;
        int y = (height - bgHeight) / 2;
        context.drawTexture(BG_TEXTURE, x, y, 0, 0, bgWidth, bgHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);

        switch (currentPage) {
            case 1:
                context.drawTexture(Identifier.of(Benjaamiins.MOD_ID, "textures/gui/slides/slide1.png"), (width / 2) - (imgWidth / 2), (height / 2 - (bgHeight / 2)) + 10, 0, 0, imgWidth, imgHeight, imgWidth, imgHeight);
                context.drawCenteredTextWithShadow(textRenderer, "Once there was Eiribeani, the omnipotent", (width / 2), (height / 2) - 70, 14211288);
                context.drawCenteredTextWithShadow(textRenderer, "essence who flowed through all creation", (width / 2), (height / 2) - 60, 14211288);
                break;
            case 2:
                context.drawTexture(Identifier.of(Benjaamiins.MOD_ID, "textures/gui/slides/slide2.png"), (width / 2) - (imgWidth / 2), (height / 2 - (bgHeight / 2)) + 10, 0, 0, imgWidth, imgHeight, imgWidth, imgHeight);
                context.drawCenteredTextWithShadow(textRenderer, "The Ieróbeanus began to harness", (width / 2), (height / 2) - 70, 14211288);
                context.drawCenteredTextWithShadow(textRenderer, "the ultimate power of the bean", (width / 2), (height / 2) - 60, 14211288);
                break;
            case 3:
                context.drawTexture(Identifier.of(Benjaamiins.MOD_ID, "textures/gui/slides/slide3.png"), (width / 2) - (imgWidth / 2), (height / 2 - (bgHeight / 2)) + 10, 0, 0, imgWidth, imgHeight, imgWidth, imgHeight);
                context.drawCenteredTextWithShadow(textRenderer, "The bean towers grew to reach the heavens", (width / 2), (height / 2) - 70, 14211288);
                context.drawCenteredTextWithShadow(textRenderer, "and their power became unmatched and mighty", (width / 2), (height / 2) - 60, 14211288);
                break;
            case 4:
                context.drawTexture(Identifier.of(Benjaamiins.MOD_ID, "textures/gui/slides/slide4.png"), (width / 2) - (imgWidth / 2), (height / 2 - (bgHeight / 2)) + 10, 0, 0, imgWidth, imgHeight, imgWidth, imgHeight);
                context.drawCenteredTextWithShadow(textRenderer, "But from within, a dark energy crept throughout", (width / 2), (height / 2) - 70, 14211288);
                context.drawCenteredTextWithShadow(textRenderer, "the city, the Ieróbeanus spiraled into ruin", (width / 2), (height / 2) - 60, 14211288);
                break;
            case 5:
                context.drawTexture(Identifier.of(Benjaamiins.MOD_ID, "textures/gui/slides/slide5.png"), (width / 2) - (imgWidth / 2), (height / 2 - (bgHeight / 2)) + 10, 0, 0, imgWidth, imgHeight, imgWidth, imgHeight);
                context.drawCenteredTextWithShadow(textRenderer, "Now all that remains are desolate bean", (width / 2), (height / 2) - 70, 14211288);
                context.drawCenteredTextWithShadow(textRenderer, "outposts, echoing a once thriving empire", (width / 2), (height / 2) - 60, 14211288);
                break;
        }

        context.drawCenteredTextWithShadow(textRenderer, currentPage + " / " + totalPages, (width / 2), (height / 2) + (bgHeight / 2) - textRenderer.fontHeight - 15, 16777215);
    }

    @Override
    protected void init() {
        super.init();

        button1 = ButtonWidget.builder(Text.literal("Next Page"), button -> {
                    if (currentPage < totalPages) {
                        currentPage++;
                    }
                    System.out.println("Current Page: " + currentPage);
                })
                .dimensions((width / 2 + (bgWidth / 2)) - 80, (height / 2 + (bgHeight / 2)) - 30, 60, 20)
                .build();
        button2 = ButtonWidget.builder(Text.literal("Last Page"), button -> {
                    if (currentPage > 1) {
                        currentPage--;
                    }
                    System.out.println("Current Page: " + currentPage);
                })
                .dimensions((width / 2 - (bgWidth / 2)) + 20, (height / 2 + (bgHeight / 2)) - 30, 60, 20)
                .build();

        addDrawableChild(button1);
        addDrawableChild(button2);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
    }
}
