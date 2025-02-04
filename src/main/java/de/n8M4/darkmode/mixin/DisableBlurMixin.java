package de.n8M4.darkmode.mixin;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class DisableBlurMixin {

    @Unique
    private Screen darkmode$self() {
        return (Screen) (Object) this;
    }

    @Inject(method = "render", at = @At("RETURN"))
    public void renderClearBackground(GuiGraphics p_281549_, int p_281550_, int p_282878_, float p_282465_, CallbackInfo ci) {
        darkmode$self().renderTransparentBackground(p_281549_);
    }
}