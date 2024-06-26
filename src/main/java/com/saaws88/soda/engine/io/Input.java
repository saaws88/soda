package com.saaws88.soda.engine.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;

public class Input {

  private static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
  private static boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
  private static double mouseX, mouseY;
  private static double scrollX, scrollY;

  private GLFWKeyCallback keyboardInput;
  private GLFWCursorPosCallback mouseMove;
  private GLFWMouseButtonCallback mouseButtons;
  private GLFWScrollCallback mouseScroll;

  public Input() {

    keyboardInput = new GLFWKeyCallback() {
      @Override
      public void invoke(long window, int key, int scancode, int action, int mods) {
        keys[key] = (action != GLFW.GLFW_RELEASE);
      }
    };

    mouseMove = new GLFWCursorPosCallback() {
      @Override
      public void invoke(long window, double xpos, double ypos) {
        mouseX = xpos;
        mouseY = ypos;
      }
    };

    mouseButtons = new GLFWMouseButtonCallback() {
      @Override
      public void invoke(long window, int button, int action, int mods) {
        buttons[button] = (action != GLFW.GLFW_RELEASE);
      }
    };

    mouseScroll = new GLFWScrollCallback() {
      @Override
      public void invoke(long window, double offsetX, double offsetY) {
        scrollX += offsetX;
        scrollY += offsetY;
      }
    };

  }

  public static boolean isKeyDown(int key) {
    return keys[key];
  }

  public static boolean isButtonDown(int button) {
    return buttons[button];
  }

  public void destroy() {
    keyboardInput.free();
    mouseMove.free();
    mouseButtons.free();
  }

  public static double getMouseX() {
    return mouseX;
  }

  public static double getMouseY() {
    return mouseY;
  }

  public GLFWKeyCallback getKeyboardInputCallback() {
    return keyboardInput;
  }

  public GLFWCursorPosCallback getMouseMoveCallback() {
    return mouseMove;
  }

  public GLFWMouseButtonCallback getMouseButtonCallback() {
    return mouseButtons;
  }

  public GLFWScrollCallback getMouseScroll() {
    return mouseScroll;
  }

}
