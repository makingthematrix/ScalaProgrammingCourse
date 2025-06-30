package io.github.template

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.ScreenUtils

import java.nio.file.Paths

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
class Main extends ApplicationAdapter:
  private var shapeRenderer: ShapeRenderer = null
  private var batch: SpriteBatch = null
  private var pawnTexture: Texture = null
  private val pawn = Pawn(Position(4, 4))

  // Chess board properties
  private val BOARD_SIZE = 8 // 8x8 chess board
  private val SQUARE_SIZE = 50f // Size of each square in pixels
  private lazy val graphicsWidth = Gdx.graphics.getWidth
  private lazy val graphicsHeight = Gdx.graphics.getHeight

  override def create(): Unit =
    println(Paths.get(".").toAbsolutePath)
    println(Pawn.icon.toAbsolutePath)
    shapeRenderer = new ShapeRenderer()
    batch = new SpriteBatch()
    pawnTexture = new Texture(Pawn.icon.toString)
    graphicsWidth
    graphicsHeight

  override def render(): Unit =
    // Clear the screen
    ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f)

    // Calculate the starting position to center the board
    val startX = (graphicsWidth - BOARD_SIZE * SQUARE_SIZE) / 2
    val startY = (graphicsHeight - BOARD_SIZE * SQUARE_SIZE) / 2

    // Begin shape rendering in filled mode
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)

    // Draw the chess board
    for row <- 0 until BOARD_SIZE do
      for col <- 0 until BOARD_SIZE do
        // Determine if the square should be black or white
        // If row + col is even, it's white; if odd, it's black
        if (row + col) % 2 == 0 then
          shapeRenderer.setColor(Color.WHITE)
        else
          shapeRenderer.setColor(Color.BLACK)

        // Draw the square
        val x = startX + col * SQUARE_SIZE
        val y = startY + row * SQUARE_SIZE
        shapeRenderer.rect(x, y, SQUARE_SIZE, SQUARE_SIZE)

    shapeRenderer.end()

    // Draw the pawn
    batch.begin()
    val pawnX = startX + pawn.position.x * SQUARE_SIZE
    val pawnY = startY + pawn.position.y * SQUARE_SIZE
    batch.draw(pawnTexture, pawnX, pawnY, SQUARE_SIZE, SQUARE_SIZE)
    batch.end()

  override def dispose(): Unit =
    shapeRenderer.dispose()
    batch.dispose()
    pawnTexture.dispose()
